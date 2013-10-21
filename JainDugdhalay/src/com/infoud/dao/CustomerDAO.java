package com.infoud.dao;

import java.sql.Connection;
import java.util.List;

import com.infoud.constants.DBOperations;
import com.infoud.constants.QueryConstants;
import com.infoud.db.DBConnection;
import com.infoud.model.OrderInfo;

public class CustomerDAO {

	DBOperations dbOperations = new DBOperations();

	public List<Object> fetchAllOrdersInfo() {
		Connection conn = DBConnection.connect();

		List<Object> orders = dbOperations.selectAllRecordsForModel(
				QueryConstants.FETCH_ALL_ORDERS_INFO_QUERY, OrderInfo.class);
		
		System.out.println(QueryConstants.FETCH_ALL_ORDERS_INFO_QUERY);

		DBConnection.close(conn);
		return orders;
	}

}
