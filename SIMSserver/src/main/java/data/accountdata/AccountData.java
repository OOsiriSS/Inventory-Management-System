package data.accountdata;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.DBManager;
import dataenum.ResultMessage;
import dataenum.findtype.FindAccountType;
import po.accountpo.AccountPO;

/**
 * 
 * @author Lijie
 * @date 2017年12月3日
 */
public class AccountData {

	public ResultMessage insert(AccountPO po) {
		Connection conn = DBManager.getConnection();// 首先拿到数据库的连接
		try {
			Statement ps0 = conn.createStatement();
			ResultSet rs = ps0.executeQuery("select count(*) from account where id = " + po.getId());
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into account(id, object) values (?,?)";
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getId());
					ps.setObject(2, po);
					ps.executeUpdate();
					conn.commit();
					ps.close();
					conn.close();
					return ResultMessage.SUCCESS;
				} else {
					System.out.println("该账户已存在");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

	public ResultMessage delete(String id) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from account where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ResultMessage update(AccountPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update account set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getId());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<AccountPO> show() {
		ArrayList<AccountPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from account";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Blob inBlob = (Blob) rs.getBlob("object"); // 获取blob对象
				InputStream is = inBlob.getBinaryStream(); // 获取二进制流对象
				BufferedInputStream bis = new BufferedInputStream(is); // 带缓冲区的流对象
				byte[] buff = new byte[(int) inBlob.length()];

				while (-1 != (bis.read(buff, 0, buff.length))) { // 一次性全部读到buff中
					ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
					AccountPO po = (AccountPO) in.readObject(); // 读出对象

					list.add(po);
				}
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;

	}

	public ArrayList<AccountPO> find(String keyword, FindAccountType type) {
		ArrayList<AccountPO> list = new ArrayList<>();
		AccountPO po = null;
		Connection conn = DBManager.getConnection();
		String sql = "" + "select object from account";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				// 以下是读取的方法一定要注意了！
				Blob inblob = (Blob) rs.getBlob("object");
				InputStream is = inblob.getBinaryStream();
				BufferedInputStream input = new BufferedInputStream(is);

				byte[] buff = new byte[(int) inblob.length()];// 放到一个buff 字节数组
				while (-1 != (input.read(buff, 0, buff.length)))
					;

				ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buff));
				po = (AccountPO) in.readObject();

				if (type == FindAccountType.ID) {
					if (keyword.equals(po.getId()))
						list.add(po);
				} else if (type == FindAccountType.NAME) {
					if (keyword.equals(po.getName()))
						list.add(po);
				} else {
					if (Double.parseDouble(keyword) == po.getMoney())
						list.add(po);
				}
			}

		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

}
