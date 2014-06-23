package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Order;

public interface OrderDao {

	void add(Order order) throws SQLException;

	Order find(String id);

	List<Order> getAll(boolean state);

	void update(Order order);

}