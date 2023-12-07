package lab6;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/java_db_lab";
        String username = "root";
        String password = "";
        DBService service = new DBService(url,username,password);

        //service.insertVehicle("car", "red", 12364, "toyota");
        //service.insertPerson("John", "Doe", 31, 1);
        service.insertPerson("Chris", "Cornell", 51, 3);
    }
}
