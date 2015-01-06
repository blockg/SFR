package comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class MainServiceImpl  implements MainService {
	
	 @Autowired  
	 private UserDao userdao;  
	 
	 
	public int lookUser() {
		 return userdao.lookUser();  
	}

 
	public int deleteUser(int id) {
		  return userdao.deleteUser(id);  
	}

}
