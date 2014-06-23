package service;

import java.sql.SQLException;
import java.util.List;

import domain.Book;
import domain.Cart;
import domain.Category;
import domain.Order;
import domain.Page;
import domain.User;

public interface BusinessService {

	/**Add category**/
	void addCategory(Category category);

	/**lookup category**/
	Category findCategory(String id);

	/**list category**/
	List getAllCategory();

	/**look book**/
	Book findBook(String id);

	/**add book**/
	void addBook(Book book);

	
	/** paging**/
	Page getPageData(String pagenum);

	Page getPageData(String pagenum, String category_id);

	void register(User user);

	User Login(String username, String password);

	void createOrder(Cart cart, User user) throws SQLException;

	Order findOrder(String order_id);

	void updateOrder(String order_id);

}