package data.salesdata;

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
import po.salespo.SalesPO;

/**
 *
 * @author Lijie
 * @date 2017年12月5日
 */
public class SalesData {

	private Connection conn;

	public SalesData() {
		conn = DBManager.getConnection();
	}

	public static void main(String[] args) {
		// ArrayList<CommodityItemPO> commodities = new ArrayList<>();
		//
		// CommodityItemPO e = new CommodityItemPO("000001", "潘星宇", "单身汪", 100,
		// 200, "汪汪");
		// commodities.add(e);
		// SalesPO po = new SalesPO("XSD-20180101-00001", "000002",
		// "王灿灿(000002)(销售商)", "王灿灿", "刘钦",
		// Warehouse.WAREHOUSE1, commodities, 2000, 200, 300, 1500, "大吉大利，晚上吃鸡",
		// BillType.SALESBILL, BillState.DRAFT);
		SalesData s = new SalesData();

		// ArrayList<SalesPO> list = s.show();
		// for (SalesPO p : list) {

		// SalesPO newPO = new
		// SalesPO(po.getId(),po.getClientId(),po.getClientName(),po.getSaleMan(),"潘星宇",
		// po.getWarehouse(),po.getCommodities(),po.getBeforePrice(),po.getAllowance(),po.getVoucher(),
		// po.getAfterPrice(),po.getRemark(),po.getType(),po.getState());
		// s.update(newPO);
		System.out.println(s.show().get(0).getOperator());
		// }
	}

	public ResultMessage insert(SalesPO po) {
		try {
			PreparedStatement ps0 = conn.prepareStatement("select count(*) from sales where id = ?");
			ps0.setString(1, po.getId());
			ResultSet rs = ps0.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into sales(id,object) value(?, ?)";
					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getId());
					ps.setObject(2, po);
					ps.executeUpdate();
					conn.commit();
					ps.close();
					return ResultMessage.SUCCESS;
				} else {
					System.out.println("该销售已存在");
					update(po);
					return ResultMessage.EXISTED;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;

	}

	public ResultMessage delete(String id) {
		String sql = "" + "delete from sales where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ResultMessage update(SalesPO po) {
		String sql = "" + "update sales set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getId());
			ps.executeUpdate();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<SalesPO> find(String keyword, FindSalesType type) {
		ArrayList<SalesPO> list = new ArrayList<>();
		String sql = "" + "select object from sales";
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
				SalesPO po = (SalesPO) in.readObject();

				switch (type) {
				case ID:
					if (keyword.equals(po.getId()))
						list.add(po);
					break;
				case MEMBER:
					if (keyword.equals(po.getClientName()))
						list.add(po);
					break;
				case TOTAL:
					if (Double.parseDouble(keyword) == po.getAfterPrice())
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

		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<SalesPO> show() {
		ArrayList<SalesPO> list = new ArrayList<>();
		String sql = "select object from sales";
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
					SalesPO po = (SalesPO) in.readObject(); // 读出对象

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
