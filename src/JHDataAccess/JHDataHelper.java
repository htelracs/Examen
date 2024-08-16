package JHDataAccess;
        
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class JHDataHelper {
    private static final String DBPathConnection = "jdbc:sqlite:JHDataBase//JHEcuaFauna.sqlite"; 
    private static Connection jhConn = null;

    protected static synchronized Connection jhOpenConnection() throws Exception{
        if(jhConn == null)
            jhConn = DriverManager.getConnection(DBPathConnection);
        return jhConn;
    }

    protected static void jhCloseConnection() throws Exception{
        if (jhConn != null)
            jhConn.close();
    }
}
