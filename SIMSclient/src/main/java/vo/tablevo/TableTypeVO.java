package vo.tablevo;

import dataenum.TableType;

public class TableTypeVO {

	TableType tableType;

	public TableTypeVO(TableType t) {
		tableType = t;
	}

	public TableType getTableType() {
		return tableType;
	}

	public void setTableType(TableType tableType) {
		this.tableType = tableType;
	}

}
