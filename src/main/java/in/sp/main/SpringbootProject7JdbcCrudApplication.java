package in.sp.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import in.sp.main.entity.User;

import in.sp.main.dao.UserDao;

@SpringBootApplication
public class SpringbootProject7JdbcCrudApplication implements CommandLineRunner{

	@Autowired
	private UserDao userDao;//object yaha aa jayega
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootProject7JdbcCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		/*
		//Insertion
		User user1= new User("Harshdeep","harsh@123","male","chandigarh");
	
		boolean status=userDao.insertUser(user1);
	
	if(status)
	{
		System.out.println("Inserted");
	}
	else 
		System.out.println("Error");
	*/
	
		/*
		
		//Updation1
		User user=new User("Harshdeep","harsh@123","male","indore");
		boolean status=userDao.updateUser(user);
		if(status)
		{
			System.out.println("Updated");
		}
		else {
			System.out.println("failed updation");
		}
	
	}
		*/
		
		//Updation2(use this) recommended
		User user=userDao.getUserByEmail("harsh@123");
		user.setCity("delhi");
		
		boolean status=userDao.updateUser(user);
		if(status)
		{
			System.out.println("Updated");
		}
		else {
			System.out.println("failed updation");
		}
	
	}
		
	/*
	
	//Deletion
	 
	 boolean status= userDao.deleteUserByEmail("pranay@21");
	 if(status)
		{
			System.out.println("Deleted");
		}
		else {
			System.out.println("failed deletion");
		}
	  
 */
	/*
	// Select One User
	 User user= userDao.getUserByEmail("harsh@123");
	 System.out.println("Name :"+user.getName());
	 System.out.println("Email :"+user.getEmail());
	 System.out.println("Gender:"+user.getGender());
	 System.out.println("City :"+user.getCity());
	 */

		/*
	 //Select all User
	  List <User> list= userDao.getAllUsers();
	 
	 for(User user:list)
	 {
	 System.out.println("Name :"+user.getName());
	 System.out.println("Email :"+user.getEmail());
	 System.out.println("Gender:"+user.getGender());
	 System.out.println("City :"+user.getCity());
	 System.out.println("--------");
	
	 }
	 */
	 
	 
	
	}


