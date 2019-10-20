package bussinesslogic.memberbl;
/**
*
* @author Lijie
* @date 2017Äê12ÔÂ16ÈÕ
*/

import dataenum.MemberCategory;
import dataenum.MemberLevel;
import po.memberpo.MemberPO;
import vo.membervo.MemberVO;

public class MemberTransition {

	public MemberVO POtoVO(MemberPO po) {
		String id = po.getId();
		MemberCategory category = po.getCategory();
		MemberLevel level = po.getLevel();
		String name = po.getName();
		String cellNumber = po.getPhone();
		String address = po.getAddress();
		String post = po.getPost();
		String email = po.getEmail();
		String receivableLimit = String.valueOf(po.getRereceivableLimit());
		String receivable = String.valueOf(po.getReceivable());
		String payable = String.valueOf(po.getPayable());
		String saleMan = po.getSaleMan();
		MemberVO vo = new MemberVO(id, category, level, name, cellNumber, address, post, email, receivableLimit,
				receivable, payable, saleMan);
		return vo;
	}

	public MemberPO VOtoPO(MemberVO vo) {
		String id = vo.getID();
		MemberCategory category = vo.getCategory();
		MemberLevel level = vo.getLevel();
		String name = vo.getName();
		String phone = vo.getCellNumber();
		String adress = vo.getAddress();
		String post = vo.getPost();
		String email = vo.getEmail();
		Double receivableLimit = Double.parseDouble(vo.getReceivableLimit());
		String saleMan = vo.getSaleMan();
		MemberPO po = new MemberPO(id, category, level, name, phone, adress, post, email, receivableLimit, saleMan);
		po.setPayable(Double.parseDouble(vo.getPayable()));
		po.setReceivable(Double.parseDouble(vo.getReceivable()));
		return po;
	}
}
