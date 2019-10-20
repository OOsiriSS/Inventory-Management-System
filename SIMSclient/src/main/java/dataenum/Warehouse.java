package dataenum;

public enum Warehouse {

	WAREHOUSE1("²Ö¿â1"), WAREHOUSE2("²Ö¿â2");

	public final String value;

	Warehouse(String value) {
		this.value = value;
	}

	public static Warehouse getWarehouse(String value) {
		return value == "²Ö¿â1" ? WAREHOUSE1 : WAREHOUSE2;
	}

}
