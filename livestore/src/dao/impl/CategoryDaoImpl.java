package dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.CategoryDao;
import domain.Category;
import utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {

	/* (non-Javadoc)
	 * @see dao.impl.CategoryDao#add(domain.Category)
	 */
	@Override
	public void add(Category category){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into category(id, name, description) values(?,?,?)";
			Object[] params = {category.getId(), category.getName(), category.getDescription()};
			
			qr.update(sql, params);
		
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.CategoryDao#find(java.lang.String)
	 */
	@Override
	public Category find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select id,name,description from category where id=?";
			return (Category) qr.query(sql, id, new BeanHandler(Category.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.CategoryDao#getAll()
	 */
	@Override
	public List<Category> getAll(){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select id,name,description from category";
			return (List<Category>) qr.query(sql, new BeanListHandler(Category.class));
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}
	
	
	
}
