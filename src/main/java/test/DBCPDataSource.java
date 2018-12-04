package test;



import org.apache.commons.dbcp2.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp2.datasources.SharedPoolDataSource;

import javax.sql.DataSource;

public class DBCPDataSource {
	private static DBCPDataSource dbcps= null;
	private static DriverAdapterCPDS cpds = null;
	private static SharedPoolDataSource tds = null;
	public static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@192.168.19.179:1521:ORCL";
	public static final String USER = "sg_uap";
	public static final String PASS = "sys";
	
	/**
	 * init connection param from properties
	 */
	private DBCPDataSource(){
		
	}
	
	/**
	 * init BasicDataSource
	 * @return basicDataSource
	 * @throws ClassNotFoundException 
	 */
	private synchronized DriverAdapterCPDS getDriverAdapterCPDS() throws ClassNotFoundException{
		if(cpds==null){
			cpds = new DriverAdapterCPDS();
			cpds.setDriver(DRIVER_CLASS);
			cpds.setUrl(URL);
			cpds.setUser(USER);
			cpds.setPassword(PASS);
			return cpds;
		}else
			return cpds;
	}
	
	/**
	 * init SharedPoolDataSource
	 * @return sharedPoolDataSource
	 * @throws ClassNotFoundException 
	 */
	private synchronized SharedPoolDataSource getSharedPoolDataSource() throws ClassNotFoundException{
		if(tds==null){
			tds = new SharedPoolDataSource();
			tds.setConnectionPoolDataSource(cpds);
			tds.setDefaultAutoCommit(false);
			tds.setDefaultMaxWaitMillis(20);
			tds.setDefaultMaxIdle(20);
			tds.setConnectionPoolDataSource(getDriverAdapterCPDS());;
		}
		return tds;
	}
	
	/**
	 * get a DataSource Object
	 * @return DataSource instance
	 * @throws ClassNotFoundException 
	 */
	public DataSource getDataSourceInstance() throws ClassNotFoundException{
		return getSharedPoolDataSource();
	}
	
	/**
	 * get a instance of DBCPDataSource
	 * @return DBCPDataSource DBCPDataSource instance
	 */
	public static DBCPDataSource getDBCPDataSource(){
		if(dbcps==null)
			dbcps = new DBCPDataSource();
		return dbcps;
	}
	
}
