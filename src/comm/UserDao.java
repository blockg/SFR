package comm;

import java.util.List;

import org.springframework.stereotype.Repository;
 
public interface UserDao {
        public int lookUser();  
	    public int deleteUser(int id);  
	  
}
