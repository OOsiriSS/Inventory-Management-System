package data.receiptbilldata;

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
import dataenum.findtype.FindAccountBillType;
import po.financialbillpo.AccountListPO;
import po.financialbillpo.ReceiptBillPO;

/**
 *
 * @author Lijie
 * @date 2017年12月14日
 */
public class ReceiptBillData {
	private Connection conn;

	public ReceiptBillData() {
		conn = DBManager.getConnection();
	}

	public static void main(String[] args) {
		ReceiptBillData d = new ReceiptBillData();
		ArrayList<AccountListPO> accountList = new ArrayList<>();
		AccountListPO account1 = new AccountListPO("00001", 5000.00, "CNJDAN");
		AccountListPO account2 = new AccountListPO("00002", 4000.00, "CADCACDA");
		accountList.add(account1);
		accountList.add(account2);

		d.delete(d.show().get(0).getDocID());
		System.out.println(d.show().get(0).getCustomer());

	}

	public ResultMessage insert(ReceiptBillPO po) {
		Connection conn = DBManager.getConnection();// 首先拿到数据库的连接
		try {
			PreparedStatement ps0 = conn.prepareStatement("select count(*) from receiptbill where id = ?");
			ps0.setString(1, po.getDocID());
			ResultSet rs = ps0.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into receiptbill(id, object) values (?,?)";

					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, po.getDocID());
					ps.setObject(2, po);
					ps.executeUpdate();
					conn.commit();
					ps.close();
					// conn.close();
					return ResultMessage.SUCCESS;
				} else {
					update(po);
					System.out.println("该收款单已存在");
					return ResultMessage.EXISTED;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.FAIL;
	}

	public ResultMessage delete(String id) {
		Connection conn = DBManager.getConnection();
		String sql = "" + "delete from receiptbill where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.execute();
			ps.close();
			// conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<ReceiptBillPO> find(String keyword, FindAccountBillType type) {
		ArrayList<ReceiptBillPO> list = new ArrayList<>();
		ReceiptBillPO po = null;
		// Connection conn = DBManager.getConnection();
		String sql = "" + "select object from receiptbill";
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
				po = (ReceiptBillPO) in.readObject();

				switch (type) {
				case BILLID:
					if (keyword.equals(po.getDocID())) {
						list.add(po);
					}
					break;
				case CUSTOMER:
					if (keyword.equals(po.getCustomerID())) {
						list.add(po);
					}
					break;
				case OPERATOR:
					if (keyword.equals(po.getUserID())) {
						list.add(po);
					}
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

	public ResultMessage update(ReceiptBillPO po) {
		// Connection conn = DBManager.getConnection();
		String sql = "" + "update receiptbill set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getDocID());
			ps.executeUpdate();
			ps.close();
			// conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	public ArrayList<ReceiptBillPO> show() {
		ArrayList<ReceiptBillPO> list = new ArrayList<>();
		// Connection conn = DBManager.getConnection();
		String sql = "select object from receiptbill";
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
					ReceiptBillPO po = (ReceiptBillPO) in.readObject(); // 读出对象

					list.add(po);
				}
			}
			rs.close();
			ps.close();
			// conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;

	}
}
