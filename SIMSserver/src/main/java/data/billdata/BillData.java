package data.billdata;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.rmi.RemoteException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.DBManager;
import dataenum.BillState;
import dataenum.BillType;
import dataenum.ResultMessage;
import dataenum.findtype.FindInventoryBillType;
import dataservice.billdataservice.BillDataService;
import po.commoditypo.GiftPO;
import po.inventorybillpo.InventoryBillPO;

public class BillData implements BillDataService {

	private Connection conn;

	public BillData() {
		conn = DBManager.getConnection();
	}

	public static void main(String[] args) {
		BillData data = new BillData();
		GiftPO gift1 = new GiftPO("鬼吹灯", 20);
		ArrayList<GiftPO> list = new ArrayList<>();
		list.add(gift1);
		InventoryBillPO bill = new InventoryBillPO("KCBYD-20180105-00001", list, "王灿灿", BillType.INVENTORYREVENUEBILL,
				BillState.COMMITED, "cbidoc");
		try {
			data.deleteInventoryBill(bill.getId());
			System.out.println(data.showInventoryBill().get(0).getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ResultMessage insertInventoryBill(InventoryBillPO inventoryBillPO) throws RemoteException {
		try {
			String sql0 = "select count(*) from inventorybill where id = ?";
			PreparedStatement ps0 = conn.prepareStatement(sql0);
			ps0.setString(1, inventoryBillPO.getId());
			// Statement ps0 = conn./createStatement();
			ResultSet rs = ps0.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
				if (count == 0) {
					String sql = "" + "insert into inventorybill(id, object) values (?,?)";

					conn.setAutoCommit(false);
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, inventoryBillPO.getId());
					ps.setObject(2, inventoryBillPO);
					ps.executeUpdate();
					conn.commit();
					ps.close();
					// conn.close();
					return ResultMessage.SUCCESS;
				} else {
					updateInventoryBill(inventoryBillPO);
					return ResultMessage.EXISTED;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ResultMessage.FAIL;

	}

	@Override
	public ResultMessage deleteInventoryBill(String id) throws RemoteException {
		String sql = "" + "delete from inventorybill where id = ?";
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

	@Override
	public ResultMessage updateInventoryBill(InventoryBillPO po) throws RemoteException {
		String sql = "" + "update inventorybill set object = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, po);
			ps.setString(2, po.getId());
			ps.executeUpdate();
			ps.close();
			// conn.close();
			return ResultMessage.SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ArrayList<InventoryBillPO> findInventoryBill(String keyword, FindInventoryBillType type)
			throws RemoteException {
		ArrayList<InventoryBillPO> list = new ArrayList<>();
		String sql = "select object from inventorybill";
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
					InventoryBillPO po = (InventoryBillPO) in.readObject(); // 读出对象

					if (type == FindInventoryBillType.ID) {
						if (keyword.equals(po.getId()))
							list.add(po);
					} else if (type == FindInventoryBillType.NAME) {
						if (keyword.equals(po.getId()))
							list.add(po);
					} else if (type == FindInventoryBillType.STATE) {
						if (keyword.equals(po.getBillState().value))
							list.add(po);
					} else if (type == FindInventoryBillType.TYPE) {
						if (keyword.equals(po.getBillType().value))
							list.add(po);
					}
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

	@Override
	public ArrayList<InventoryBillPO> showInventoryBill() throws RemoteException {
		ArrayList<InventoryBillPO> list = new ArrayList<>();
		// Connection conn = DBManager.getConnection();
		String sql = "select object from inventorybill";
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
					InventoryBillPO po = (InventoryBillPO) in.readObject(); // 读出对象

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
