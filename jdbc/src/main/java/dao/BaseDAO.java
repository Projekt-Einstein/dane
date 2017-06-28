package dao;

import org.apache.commons.dbutils.DbUtils;

import java.sql.*;

/**
 * @author Dominik Ciborowski
 */
public abstract class BaseDAO {

    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test?user=test&password=test&useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);

        return DriverManager.getConnection(URL);
    }

    protected ResultSet executeQuery(String sql, Object... params) throws SQLException {
        Connection connection = null;
        PreparedStatement stmnt = null;
        ResultSet resultSet = null;

        try {
            connection = createConnection();
            stmnt = connection.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                stmnt.setObject(i + 1, params[i]);
            }

            resultSet = stmnt.executeQuery();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();

            throw e;
        }

        return resultSet;
    }

}
