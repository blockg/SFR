package comm;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.transaction.TransactionConfiguration;


public class BaseDao    {
     @Autowired  
	    private SessionFactory sessionFactory;  	   
	    public Session getCurrentSession(){  
	        return sessionFactory.getCurrentSession();  
	    }  
	  
 
 
}
