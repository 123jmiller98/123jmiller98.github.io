package edu.mcckc.dao;

import org.apache.log4j.*;

import java.sql.*;

public abstract class ABaseDao
{

    // NOTE: DAO mean Data Access Object

    // standard functionality that never changes goes in the parent class

    private static Logger logger = Logger.getLogger(ABaseDao.class);

    private ConfigProperties configProperties;

    private final String DB_DRIVER_KEY = "DB_DRIVER";
    private final String DB_CONNECTION_KEY = "DB_CONNECTION";
    private final String DB_USER_KEY = "DB_USER";
    private final String DB_PASSWORD_KEY = "DB_PASSWORD";


    private String DB_DRIVER;
    private String DB_CONNECTION;
    private String DB_USER;
    private String DB_PASSWORD;


    protected Connection conn;
    protected Statement stmt;
    protected ResultSet rs;
    protected PreparedStatement ps;
    protected String sql;

    public ABaseDao() throws Exception
    {
        this("sqlconfig.properties");
        logger.debug("Inside the edu.mcckc.dao.ABaseDao DEFAULT constructor");
    }

    public ABaseDao(String configFileName) throws Exception
    {
        configProperties = new ConfigProperties(configFileName);
        configProperties.displayProperties();

        DB_DRIVER = configProperties.getProperty(DB_DRIVER_KEY);
        DB_CONNECTION = configProperties.getProperty(DB_CONNECTION_KEY);
        DB_USER = configProperties.getProperty(DB_USER_KEY);
        DB_PASSWORD = configProperties.getProperty(DB_PASSWORD_KEY);

        logger.debug("DB_DRIVER: " + DB_PASSWORD);
        logger.debug("DB_CONNECTION: " + DB_CONNECTION);
        logger.debug("DB_USER: " + DB_USER);
        logger.debug("DB_PASSWORD: " + DB_PASSWORD);

        createDBConnection();

    }

    protected void createDBConnection() throws Exception
    {
        logger.debug("Inside edu.mcckc.dao.ABaseDao createDBConnection");

        if(conn == null)
        {
            try
            {
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_CONNECTION);
                logger.debug("Opened database successfully");
            }
            catch (Exception ex)
            {
                logger.error(ex.getMessage());
                throw ex;
            }

        }
    }


    protected void dbCleanup() throws Exception
    {
        logger.debug("inside edu.mcckc.dao.ABaseDao dbCleanup");

        try
        {
            if (ps != null && !ps.isClosed())
            {
                ps.close();
                ps = null;
            }
            if (rs != null && !rs.isClosed())
            {
                rs.close();
                rs = null;
            }
            if (stmt != null && !stmt.isClosed())
            {
                stmt.close();
                stmt = null;
            }
            if (conn != null && !conn.isClosed())
            {
                conn.close();
                conn = null;
            }

        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
            throw ex;
        }

    }


}
