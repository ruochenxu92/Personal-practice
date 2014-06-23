package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.JdbcUtils;
import dao.UserDao;
import domain.User;

public class UserDaoImpl implements UserDao {

	/* (non-Javadoc)
	 * @see dao.impl.UserDao#add(domain.User)
	 */
	@Override
	public void add(User user){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into user value(?,?,?,?,?,?)";
			
			Object[] params = new Object[]{user.getId(), user.getUsername(), user.getPassword(), user.getEmail(),
					user.getPhone(),user.getAddress()};
			qr.update(sql, params);
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.UserDao#find(java.lang.String)
	 */
	@Override
	public User find(String id){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=";
			return (User) qr.query(sql, id, new BeanHandler(User.class));
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username, String password){
		try{
			QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object[] params = new Object[]{username, password};
			return (User) qr.query(sql,params, new BeanHandler(User.class));

		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
		
	
	
}
