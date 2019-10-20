package data.commoditydata;

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
import dataenum.findtype.FindCommodityType;
import po.commoditypo.CommodityPO;

public class CommodityData {

	public static void main(String[] args) {
		CommodityData cd = new CommodityData();
		CommodityPO po = new CommodityPO("黑灯-0001", "黑夜追凶灯", "L", "黑灯", 200, 25, 29, 24, 28, 2000);
		cd.insert(po);
		System.out.println(cd.show().get(0).getID());
	}

	public void stock() {

	}

	public ResultMessage insert(CommodityPO po) {
		Connection conn = DBManager.getConnection();// 首先拿到数据库的连接
		try {
			// Statement ps0 = conn.createStatement();
			// ResultSet rs = ps0.executeQuery("select count(*) from commodity
			// where id = " + po.getID());
			// int count = 0;
			// if (rs.next()) {
			// count = rs.getInt(1);
			// if (count == 0) {
			String sql = "" + "insert into commodity(id, object) values (?,?)";

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, po.getID());
			ps.setObject(2, po);
			ps.executeUpdate();
			conn.commit();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
			// }
			// else {
			// System.out.println("商品ID已存在");
			// }
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.FAIL;
	}

	public ResultMessage delete(String id) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from commodity where id = ?";
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

	public ResultMessage update(CommodityPO po) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "update commodity set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getID());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<CommodityPO> find(String keyword, FindCommodityType type) {
		ArrayList<CommodityPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from commodity";
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
					CommodityPO po = (CommodityPO) in.readObject(); // 读出对象

					switch (type) {
					case ID:
						if (keyword.equals(po.getID()))
							list.add(po);
						break;
					case NAME:
						if (keyword.equals(po.getName()))
							list.add(po);

					default:
						break;
					}

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

	public ArrayList<CommodityPO> show() {
		ArrayList<CommodityPO> list = new ArrayList<>();
		Connection conn = DBManager.getConnection();
		String sql = "select object from commodity";
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
					CommodityPO po = (CommodityPO) in.readObject(); // 读出对象

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

}
