package comm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

@Repository 
public class UserDaoImpl extends BaseDao implements UserDao  {
 
	/** 
     * ��ѯ���� 
     */  
    public int lookUser(){  
        //Query query = getCurrentSession().createSQLQuery("SELECT COUNT(*) FROM t_user");  
 
        Query query = getCurrentSession().createSQLQuery("select * from DSE_USERINFO");  
        @SuppressWarnings("unchecked")
		List<Object> l = query.list();  
        return  l.size() ;  
    }  
      
    /** 
     * ɾ�������� 
     * @return 
     */  
    
    public int deleteUser(int id){  
        Query query =  getCurrentSession().createSQLQuery("DELETE  FROM t_user where id = "+id);  
        return query.executeUpdate();  
    }  
      
    /** 
     * ������� 
     * @param user 
     */  
    public void saveUser( ){  
      //  getCurrentSession().save();  
    } 
}
