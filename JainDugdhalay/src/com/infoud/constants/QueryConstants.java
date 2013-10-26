package com.infoud.constants;

public class QueryConstants {
	public static final String FETCH_ALL_ORDERS_INFO_QUERY = "SELECT o."
			+ DBConstants.COLUMN_ORDER_OID + " as oid, c."
			+ DBConstants.COLUMN_CUSTOMER_CNAME + " as customerName, o."
			+ DBConstants.COLUMN_ORDER_PLACE_OF_DELIVERY
			+ " as place_of_delivery, o."
			+ DBConstants.COLUMN_ORDER_DATE_AND_TIME_OF_DELIVERY
			+ " as date_and_time_of_delivery, o."
			+ DBConstants.COLUMN_ORDER_AMOUNT + " as amount FROM "
			+ DBConstants.TABLE_CUSTOMER + " c," + DBConstants.TABLE_ORDER
			+ " o where c." + DBConstants.COLUMN_CUSTOMER_CID + " = o."
			+ DBConstants.COLUMN_ORDER_CID;
}
