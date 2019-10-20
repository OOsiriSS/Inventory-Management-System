package data.purchasedata;
/**
*
* @author Lijie
* @date 2017年12月8日
*/

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
import java.util.ArrayList;

import data.DBManager;
import dataenum.ResultMessage;
import dataenum.findtype.FindSalesType;
import po.purchasepo.PurchasePO;

public class PurchaseData {

	private Connection conn;

	public PurchaseData() {
		conn = DBManager.getConnection();
	}


	public ResultMessage insert(PurchasePO po) {

		try {
			PreparedStatement ps0 = conn.prepareStatement("select count(*) from purchase where id = ?");
			ps0.setString(1, po.getId());
			ResultSet rs = ps0.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into purchase(id,object) value(?, ?)";
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getId());
					ps.setObject(2, po);
					ps.executeUpdate();
					conn.commit();
					ps.close();
					return ResultMessage.SUCCESS;
				} else {
					update(po);
					System.out.println("该进货单已存在");
					return ResultMessage.EXISTED;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}

	public ResultMessage delete(String id) {
		String sql = "" + "delete from purchase where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			ps.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ResultMessage update(PurchasePO po) {
		String sql = "" + "update purchase set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getId());
			ps.executeUpdate();
			ps.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<PurchasePO> find(String keyword, FindSalesType type) {
		ArrayList<PurchasePO> list = new ArrayList<>();
		String sql = "" + "select object from purchase";
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
				PurchasePO po = (PurchasePO) in.readObject();

				switch (type) {
				case ID:
					if (keyword.equals(po.getId()))
						list.add(po);
					break;
				case MEMBER:
					if (keyword.equals(po.getMember()))
						list.add(po);
					break;
				case TOTAL:
					if (Double.parseDouble(keyword) == po.getSum())
						list.add(po);
					break;
				case OPERATOR:
					if (keyword.equals(po.getOperator()))
						list.add(po);
					break;

				default:
					break;
				}
			}

			ps.close();

		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<PurchasePO> show() {
		ArrayList<PurchasePO> list = new ArrayList<>();
		String sql = "select object from purchase";
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
					PurchasePO po = (PurchasePO) in.readObject(); // 读出对象

					list.add(po);
				}
			}
			rs.close();
			ps.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;

	}
}
