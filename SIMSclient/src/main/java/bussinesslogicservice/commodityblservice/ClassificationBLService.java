package bussinesslogicservice.commodityblservice;

import java.util.ArrayList;

import dataenum.ResultMessage;
import po.classificationvpo.ClassificationVPO;

public interface ClassificationBLService {

	public String getID();

	public ResultMessage insert(ClassificationVPO vpo);

	public void delete(ClassificationVPO vpo);

	public ResultMessage update(ClassificationVPO vpo);

	public ArrayList<String> showName();

	public ClassificationVPO getClass(String name);

	public ClassificationVPO getRoot();

}
