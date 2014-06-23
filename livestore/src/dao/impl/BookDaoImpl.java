package dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.JdbcUtils;
import dao.BookDao;
import domain.Book;

public class BookDaoImpl implements BookDao  {
	/*
	 * 	private String id;
	private String name;
	private String author;
	private double price;
	private String image;
	private String description;
	private String category_id;
	 */
	
	
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#add(domain.Book)
	 */
	@Override
	public void add(Book book){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into book values(?,?,?,?,?,?,?)";
			Object[] params = {book.getId(),book.getName(),book.getAuthor(), book.getPrice(),book.getImage(),book.getDescription(),book.getCategory_id()};
			
			qr.update(sql, params);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#find(java.lang.String)
	 */
	@Override
	public Book find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select id,name,author,price,image,description,category_id from book where id=?";
			return (Book) qr.query(sql, id, new BeanHandler(Book.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}

	}
	
	
	
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#add(domain.Book)
	 */
	@Override
	public List<Book> getPageBook(int startIndex, int pageSize){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book limit ?,?";
			Object[] params = {startIndex, pageSize};
			return (List<Book>) qr.query(sql, params, new BeanListHandler(Book.class));

		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#add(domain.Book)
	 */
	@Override
	public int getTotalNumber(){
		
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from book";
			long l = (long) qr.query(sql,new ScalarHandler());
			System.out.println(l);
			return (int) l;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	
	
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#add(domain.Book)
	 */
	@Override
	public List<Book> getPageBook(int startIndex, int pageSize, String category_id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			System.out.println(startIndex + " start index");
			String sql = "select * from book where category_id=? limit ?,?";
			Object[] params = {category_id, startIndex, pageSize};
			return (List<Book>) qr.query(sql, params, new BeanListHandler(Book.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see dao.impl.BookDao#add(domain.Book)
	 */
	@Override
	public int getTotalNumber(String category_id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from book where category_id=?";
			long l = (long) qr.query(sql,category_id, new ScalarHandler());
			return (int) l;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	
}
