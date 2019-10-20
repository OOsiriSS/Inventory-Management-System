package bussiness_stub;

import java.util.ArrayList;
import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.ResultMessage;
import po.classificationvpo.ClassificationVPO;

public class ClassificationBLService_Stub implements ClassificationBLService {

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return "00001556";
	}

	@Override
	public ResultMessage insert(ClassificationVPO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public void delete(ClassificationVPO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ResultMessage update(ClassificationVPO vo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ClassificationVPO getClass(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassificationVPO getRoot() {
		// TODO Auto-generated method stub
		ClassificationVPO root = new ClassificationVPO("0001", "µÆ", false, null, null, null);
		// ArrayList<ClassificationVPO> children = new ArrayList<>();
		// ArrayList<ClassificationVPO> children1 = new ArrayList<>();
		// ClassificationVPO c1 = new
		// ClassificationVPO("0002","°×³ãµÆ",true,root,null);
		// ClassificationVPO c2 = new
		// ClassificationVPO("0003","ÕÕÃ÷µÆ",true,root,null);
		// ClassificationVPO c3 = new
		// ClassificationVPO("0004","ºÚµÆ",true,root,null);
		// ClassificationVPO c11 = new
		// ClassificationVPO("0005","°×°×³ãµÆ",true,c1,null);
		// ClassificationVPO c12 = new
		// ClassificationVPO("0006","ºÚ°×³ãµÆ",true,c1,null);
		// children1.add(c11);
		// children1.add(c12);
		// c1.setChildren(children1);
		// children.add(c1);
		// children.add(c2);
		// children.add(c3);
		//
		// root.setChildren(children);
		return root;
	}

	@Override
	public ArrayList<String> showName() {
		ArrayList<String> names = new ArrayList<>();
		names.add("µÆ");
		return names;
	}

}
