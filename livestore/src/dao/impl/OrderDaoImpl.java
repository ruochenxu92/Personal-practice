package dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JdbcUtils;
import dao.OrderDao;
import domain.Book;
import domain.Order;
import domain.OrderItem;
import domain.User;

public class OrderDaoImpl implements OrderDao {

	/* (non-Javadoc)
	 * @see dao.OrderDao#add(domain.Order)
	 */
	@Override
	public void add(Order order) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into orders(id,ordertime, price,state,user_id) values(?,?,?,?,?)";
		Object[] params = {order.getId(), order.getOrdertime(),order.getPrice(),order.isState(), order.getUser().getId()};
		qr.update(sql,params);
		
		sql = "insert into orderitem() values(?,?,?,?,?)";
		Set<OrderItem> set = order.getOrderitems();
		Object[][] params2 = new Object[set.size()][];
		int i = 0;
		for(OrderItem item :set){
			System.out.println(item.getQuantity());
			System.out.println(item.getPrice());
			System.out.println(item.getId());
			System.out.println(item.getBook());
			params2[i] = new Object[]{item.getId(),item.getQuantity(),item.getPrice(),order.getId(),item.getBook().getId()};
			i++;
		}
		qr.batch(sql, params2);	
	}
	
	/* (non-Javadoc)
	 * @see dao.OrderDao#find(java.lang.String)
	 */
	@Override
	public Order find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			Order order = new Order();
			//get basic information about order
			String sql = "select * from orders where id=?";
			order = (Order) qr.query(sql, id, new BeanHandler(Order.class));
			
			sql = "select * from orderitem where order_id = ?";
			List<OrderItem> list = (List<OrderItem>) qr.query(sql, id, new BeanListHandler(OrderItem.class));
			
			
			//2. get responsible book and put it on OrderItem
			for(OrderItem item : list){
				sql ="select book.* from book,orderitem where book.id=orderitem.book_id and orderitem.id=?";
				Book book = (Book) qr.query(sql,item.getId(),new BeanHandler(Book.class));
				item.setBook(book);
				order.getOrderitems().add(item);
			}
			
			sql = "select user.* from user,orders where user.id=orders.user_id and orders.id=?";
			User user = (User) qr.query(sql, id, new BeanHandler(User.class));
			order.setUser(user);
			
			
			
			return order;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see dao.OrderDao#getAll(boolean)
	 */
	@Override
	public List<Order> getAll(boolean state){
		try{
			QueryRunner qr =new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where state = ?";
			List<Order> list = (List<Order>) qr.query(sql,state, new BeanListHandler(Order.class));
			
		
			for(Order order : list){
				sql = "select user.* from orders, user where orders.id=? and orders.user_id=user.id";
				//get orders
				User user = (User) qr.query(sql, order.getId(), new BeanHandler(User.class));
				order.setUser(user);
			}
			return list;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.OrderDao#update(domain.Order)
	 */
	@Override
	public void update(Order order){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "update orders set state=? where id=?";
			Object params[]= {order.isState(), order.getId()};
			qr.update(sql, params);
	
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
