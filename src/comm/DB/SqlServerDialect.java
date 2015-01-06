package comm.DB;

import java.sql.Types;

import org.hibernate.dialect.SQLServer2008Dialect;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;



public class SqlServerDialect extends SQLServer2008Dialect {
 
	 public SqlServerDialect() {
		super();
		registerHibernateType(Types.CHAR, StringType.INSTANCE.getName());
		registerHibernateType(Types.NVARCHAR, StringType.INSTANCE.getName());
		registerHibernateType(Types.LONGNVARCHAR, StringType.INSTANCE.getName());
		registerHibernateType(Types.DECIMAL, DoubleType.INSTANCE.getName());
		registerHibernateType(Types.NCHAR,StringType.INSTANCE.getName());
	}
}