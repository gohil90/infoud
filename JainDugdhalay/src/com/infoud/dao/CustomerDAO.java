package com.infoud.dao;

import java.sql.Connection;
import java.sql.Types;
import java.util.List;

import com.infoud.constants.QueryConstants;
import com.infoud.db.DBConnection;
import com.infoud.db.DBOperations;
import com.infoud.model.OrderInfo;

public class CustomerDAO {

	DBOperations dbOperations = new DBOperations();

	public List<Object> fetchAllOrdersInfo() {
		Connection conn = DBConnection.connect();

		List<Object> orders = dbOperations.getAllRecordsForModel(
				QueryConstants.FETCH_ALL_ORDERS_INFO_QUERY, OrderInfo.class,
				null, null);

		System.out.println(QueryConstants.FETCH_ALL_ORDERS_INFO_QUERY);

		DBConnection.close(conn);
		return orders;
	}

}
