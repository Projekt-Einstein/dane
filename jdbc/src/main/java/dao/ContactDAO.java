package dao;

import model.Contact;
import org.apache.commons.dbutils.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dominik Ciborowski
 */
public class ContactDAO extends BaseDAO {

    private static final String ALL_CONTACTS = "select name, surname, phoneNo, email from Contact";
    private static final String CONTACT_BY_EMAIL = "select name, surname, phoneNo, email from Contact where email = ?";


    public List<Contact> getAllContacts() {
        ResultSet rs = null;

        List<Contact> contactList = new ArrayList<>();

        try {
            rs = executeQuery(ALL_CONTACTS);

            while (rs.next()) {
                contactList.add(getNextContactFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();

            throw new RuntimeException(e);
        } finally {
            try {
                DbUtils.closeQuietly(rs.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return contactList;
    }

    public Contact getContactByEmail(String email) throws SQLException {
        ResultSet resultSet = executeQuery(CONTACT_BY_EMAIL, email);

        return (resultSet.next())? getNextContactFromResultSet(resultSet) : null;
    }

    private Contact getNextContactFromResultSet(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phoneNo = rs.getString("phoneNo");
        String email = rs.getString("email");

        return new Contact(name, surname, phoneNo, email);
    }

}
