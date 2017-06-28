import dao.ContactDAO;

import java.sql.SQLException;

/**
 * @author Dominik Ciborowski
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ContactDAO contactDAO = new ContactDAO();

        System.out.println(contactDAO.getAllContacts());

        System.out.println(contactDAO.getContactByEmail("Email 2"));
    }

}
