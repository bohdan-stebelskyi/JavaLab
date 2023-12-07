package lab5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBService {

    final String url;
    final String username;
    final String password;
    final Connection connection;

    DBService(String url, String username, String password) throws SQLException, ClassNotFoundException {
        this.url = url;
        this.username = username;
        this.password = password;
        connection = getConnection();
    }
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url,username,password);
    }
    void dropAllTables() throws ClassNotFoundException, SQLException {
        String sqlStatement[] =
                {
                        "drop table if exists person",
                        "drop table if exists vehicle"
                };
        Statement statement = connection.createStatement();
        for (String sqlSt:sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables have been removed!");
    }
    void createAllTables() throws SQLException {
        String sqlStatement[]=
                {
                        """
                        create table java_db_lab.vehicle (
                            id int not null auto_increment,
                            type varchar(100) not null,
                            color varchar(100) not null,
                            numbers int not null,
                            model varchar(100) not null,
                            constraint pk_vehicle primary key (id)
                        );
                        """,
                        """
                         create table java_db_lab.person (
                            id int not null auto_increment,
                            name varchar(100) not null,
                            surname varchar(100) not null,
                            age int not null,
                            id_vehicle int,
                            constraint pk_person primary key (id),
                            foreign key (id_vehicle) references java_db_lab.vehicle(id) on update cascade on delete set null
                        );
                        """
                };

        Statement statement = connection.createStatement();
        for (String sqlSt:sqlStatement) {
            statement.execute(sqlSt);
        }
        System.out.println("All tables have been created!");
    }
}