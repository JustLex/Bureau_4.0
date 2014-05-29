package by.zhakov.bureau.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class ConnectionsPool
{
    public static final Logger LOG = Logger.getLogger(ConnectionsPool.class);

    private static String DRIVER_NAME="com.mysql.jdbc.Driver";
    private static ConnectionsPool instance;

    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "dbSettings";
    private static final String URL_NAME = "db.url";
    private static final String USER_NAME = "db.user";
    private static final String PASSWORD_NAME = "db.password";
    private static final String MAX_USERS = "db.maxUsers";

    private String url;
    private String user;
    private String password;
    private int maxConnection;
    private ArrayList<Connection> freeConnections=new ArrayList<Connection>();

    private ConnectionsPool()
    {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        this.url = resourceBundle.getString(URL_NAME);
        this.user = resourceBundle.getString(USER_NAME);
        this.password = resourceBundle.getString(PASSWORD_NAME);
        this.maxConnection = Integer.parseInt(resourceBundle.getString(MAX_USERS));
        loadDrivers();
    }

    private void loadDrivers()
    {
        try
        {
            Class.forName(DRIVER_NAME);
        }
        catch (ClassNotFoundException e)
        {
            LOG.error(e.getMessage());
        }

    }

    static synchronized public ConnectionsPool getInstance()
    {
        if (instance == null)
        {
            instance = new ConnectionsPool();
        }
        return instance;
    }

    @SuppressWarnings("resource")
	public synchronized Connection getConnection()
    {
        Connection con = null;
        if (!freeConnections.isEmpty())
        {
            con = (Connection) freeConnections.get(freeConnections.size()-1);
            freeConnections.remove(con);
            try
            {
                if (con.isClosed())
                {
                    con = getConnection();
                }
            }
            catch (SQLException e)
            {
                con = getConnection();
                LOG.error(e.getMessage());
            }
            catch (Exception e)
            {
                con = getConnection();
                LOG.error(e.getMessage());
            }
        }
        else
        {
            con = newConnection();
        }
        return con;
    }

    private Connection newConnection()
    {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e)
        {
            LOG.error(e.getMessage());
            return null;
        }
        return con;
    }

    public synchronized void freeConnection(Connection con)
    {
        if ( (con != null) && (freeConnections.size() <= maxConnection) )
        {
            freeConnections.add(con);
        }
    }
}