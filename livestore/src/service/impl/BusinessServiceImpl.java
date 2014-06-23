package service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import dao.BookDao;
import dao.CategoryDao;
import dao.OrderDao;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.Book;
import domain.Cart;
import domain.CartItem;
import domain.Category;
import domain.Order;
import domain.OrderItem;
import domain.Page;
import domain.User;
import service.BusinessService;
import utils.DaoFactory;
import utils.WebUtils;

public class BusinessServiceImpl implements BusinessService {
	private CategoryDao cdao = DaoFactory.getInstance().createDao("dao.impl.CategoryDaoImpl", CategoryDao.class);
	private BookDao bdao = DaoFactory.getInstance().createDao("dao.impl.BookDaoImpl", BookDao.class);
	private UserDao udao = DaoFactory.getInstance().createDao("dao.impl.UserDaoImpl", UserDao.class);
	private OrderDao odao = DaoFactory.getInstance().createDao("dao.impl.OrderDaoImpl", OrderDao.class);
	
	@Test
	public void testadd() {
		Category category = new Category();
		category.setId("123");
		category.setName("database");
		category.setDescription("database series");
		cdao.add(category);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#addCategory(domain.Category)
	 */
	@Override
	public void addCategory(Category category){
		cdao.add(category);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#findCategory(java.lang.String)
	 */
	@Override
	public Category findCategory(String id){
		return cdao.find(id);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#getAllCategory()
	 */
	@Override
	public List<Category> getAllCategory(){
		return cdao.getAll();
	}
	
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#getAllCategory()
	 */
	@Override
	public void addBook(Book book){
		 bdao.add(book);
	}
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#getAllCategory()
	 */
	@Override
	public Book findBook(String id){
		return bdao.find(id);
	}
	
	/* (non-Javadoc)
	 * @see service.impl.BusinessService#getAllCategory()
	 */
	@Override
	public Page getPageData(String pagenum){
		int totalrecords = bdao.getTotalNumber();
		Page p = null;
		if(pagenum == null){
			p = new Page(totalrecords, 1);
		}else{
			p = new Page(totalrecords, Integer.parseInt(pagenum));
		}
		p.setList(bdao.getPageBook(p.getStartindex(), p.getPagesize()));
		return p;
	}
	
	
	@Override
	public Page getPageData(String pagenum, String category_id){
		int totalrecords = bdao.getTotalNumber(category_id);
		Page p = null;
		if(pagenum == null){
			p = new Page(totalrecords, 1);
		}else{
			p = new Page(totalrecords, Integer.parseInt(pagenum));
		}
		p.setList(bdao.getPageBook(p.getStartindex(), p.getPagesize(),category_id));
		return p;
		
	}

	@Override
	public void register(User user) {
		udao.add(user);
	}

	@Override
	public User Login(String username, String password) {
		return udao.find(username, password);
	}
	
	
	@Override
	public void createOrder(Cart cart, User user) throws SQLException{
		if(cart == null){
			throw new RuntimeException("Sorry, you have not put any item on cart now!");
		}
		Order order = new Order();
		order.setId(WebUtils.generateUUID());
		order.setOrdertime("06-24-2014");
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);
		Map<String, CartItem> map =  cart.getMap();
		
		for(Map.Entry<String, CartItem> me: map.entrySet()){
			CartItem citem = me.getValue();
			OrderItem oitem = new OrderItem();
			
			oitem.setId(WebUtils.generateUUID());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			oitem.setBook(citem.getBook());
		
			order.getOrderitems().add(oitem);
		}
		odao.add(order);
	}

	public  List<Order> listOrder(String state) {
		return odao.getAll(Boolean.parseBoolean(state));
		
	}
	
	
	@Override
	public Order findOrder(String order_id) {
		return odao.find(order_id);
	}
	
	
	@Override
	public void updateOrder(String order_id) {
		Order order = odao.find(order_id);
		order.setState(true);
		odao.update(order);
	}

}

