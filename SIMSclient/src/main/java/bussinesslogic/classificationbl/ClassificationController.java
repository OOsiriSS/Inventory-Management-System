package bussinesslogic.classificationbl;

import java.util.ArrayList;

import bussinesslogicservice.commodityblservice.ClassificationBLService;
import dataenum.ResultMessage;
import po.classificationvpo.ClassificationVPO;

public class ClassificationController implements ClassificationBLService {

	ClassificationBL classificationBL = new ClassificationBL();

	@Override
	public String getID() {
		return classificationBL.getID();
	}

	@Override
	public ResultMessage insert(ClassificationVPO vpo) {
		return classificationBL.insert(vpo);
	}

	@Override
	public void delete(ClassificationVPO vpo) {
		classificationBL.delete(vpo);
	}

	@Override
	public ResultMessage update(ClassificationVPO vpo) {
		return classificationBL.update(vpo);
	}

	@Override
	public ArrayList<String> showName() {
		return classificationBL.showName();
	}

	@Override
	public ClassificationVPO getClass(String name) {
		return classificationBL.getClass(name);
	}

	@Override
	public ClassificationVPO getRoot() {
		return classificationBL.getRoot();
	}

}
