package lab5;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/java_db_lab";
        String username = "root";
        String password = "";
        DBService service = new DBService(url,username,password);

        //service.createAllTables();
        service.dropAllTables();
    }
}
