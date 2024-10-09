package in.sp.main.dao;
import in.sp.main.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
//crud operation methods
public class UserDao
{

	//bean and jdbc template configure by spring boot 
	@Autowired
	private JdbcTemplate jdbcTemplate;//Jdctemplate-methods to perform db operations
	
	
	public boolean insertUser(User user)//user object se values get karwa rhe
	{
		boolean status=false;
		
		try {
		String INSERT_SQL_QUERY="INSERT INTO users(name,email,gender,city) VALUES(?,?,?,?)";
		int count=jdbcTemplate.update(INSERT_SQL_QUERY,user.getName(),user.getEmail(),user.getGender(),user.getCity());
				
				if(count>0) {
			status=true;
		}
		else {
			
			status=false;
		}
		}
		catch(Exception ex) {
			status=false;
			ex.printStackTrace();
		                    }
		
		return status;
		}
		
	
	public boolean updateUser(User user)
	{
		boolean status=false;
		
		try {
		String UPDATE_SQL_Query="UPDATE users SET name=?,gender=?,city=? WHERE email=? ";
		int count=jdbcTemplate.update(UPDATE_SQL_Query,user.getName(),user.getGender(),user.getCity(),user.getEmail());
		if(count>0) {
			status=true;
		}
else {
			
			status=false;
		}
		}
		catch(Exception ex) {
			status=false;
			ex.printStackTrace();
		                    }
		
		return status;
	}
	
	public boolean deleteUserByEmail(String email)
	{
		boolean status=false;
		
		try {
		String Delete_SQL_Query="Delete from  users WHERE email=? ";
		int count=jdbcTemplate.update(Delete_SQL_Query,email);
		if(count>0) {
			status=true;
		}
else {
			
			status=false;
		}
		}
		catch(Exception ex) {
			status=false;
			ex.printStackTrace();
		                    }
		
		return status;
	}
	
	
	public User getUserByEmail(String email)
	{
		
		String Select_SQL_Query="Select * from  users WHERE email=? ";
		 return jdbcTemplate.queryForObject(Select_SQL_Query,new UserRowMapper(),email);
		//predefined interface to get
		}
	
	
	//view list of users
		public List<User> getAllUsers()
		{
			
			String SELECT_SQL_QUERY="SELECT * FROM users";
	      //return value in list
			return jdbcTemplate.query(SELECT_SQL_QUERY,new UserRowMapper());	
	    }
		
	
	//inner class for rowmapper
	public static final class UserRowMapper implements RowMapper<User>
	{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			User user=new User();
			user.setName(rs.getString("name"));//get value from data and set into user object 
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			
			return user;
		}
		
	}
	

	
}


