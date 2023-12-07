package lab6;

import java.sql.*;

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
        return DriverManager.getConnection(url,username,password);
    }

    // Метод для створення запису про транспортний засіб
    public void insertVehicle(String type, String color, int numbers, String model) throws SQLException {
        String sql = "INSERT INTO java_db_lab.vehicle (type, color, numbers, model) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, color);
            preparedStatement.setInt(3, numbers);
            preparedStatement.setString(4, model);
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("Vehicle with ID " + id + " has been inserted");
                }
            }
        }
    }

    // Метод для створення запису про людину
    public void insertPerson(String firstName, String lastName, int age, int vehicleId) throws SQLException {
        String sql = "INSERT INTO java_db_lab.person (name, surname, age, id_vehicle) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, vehicleId);
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    System.out.println("Person with ID " + id + " has been inserted");
                }
            }
        }
    }

    // Метод для отримання інформації про транспортний засіб за його ID
    public ResultSet getVehicleById(int vehicleId) throws SQLException {
        String sql = "SELECT * FROM java_db_lab.vehicle WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, vehicleId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Information about vehicle with ID " + vehicleId + " has been retrieved");
                    return resultSet;
                } else {
                    System.out.println("Vehicle not found with ID " + vehicleId);
                    return null;
                }
            }
        }
    }

    // Метод для отримання інформації про людину за його ID
    public ResultSet getPersonById(int personId) throws SQLException {
        String sql = "SELECT * FROM java_db_lab.person WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, personId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Information about person with ID " + personId + " has been retrieved");
                    return resultSet;
                } else {
                    System.out.println("Vehicle not found with ID " + personId);
                    return null;
                }
            }
        }
    }

    // Метод для оновлення інформації про транспортний засіб
    public void updateVehicle(long vehicleId, String type, String color, int numbers, String model) throws SQLException {
        String sql = "UPDATE java_db_lab.vehicle SET type = ?, color = ?, numbers = ?, model = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, color);
            preparedStatement.setInt(3, numbers);
            preparedStatement.setString(4, model);
            int rowsAffected = preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    if(rowsAffected > 0){
                        System.out.println("Vehicle with ID " + id + " has been inserted");
                    }else{
                        System.out.println("No vehicle found with ID " + id);
                    }

                }
            }
        }
    }

    // Метод для оновлення інформації про людину
    public void updatePerson(String firstName, String lastName, int age, int vehicleId) throws SQLException {
        String sql = "UPDATE java_db_lab.person SET name = ?, surname = ?, age = ?, id_vehicle = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, vehicleId);
            int rowsAffected = preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    if(rowsAffected > 0){
                        System.out.println("Person with ID " + id + " has been inserted");
                    }else{
                        System.out.println("No person found with ID " + id);
                    }

                }
            }
        }
    }

    // Метод для видалення транспортного засобу за його ID
    public void deleteVehicle(int vehicleId) throws SQLException {
        String sql = "DELETE FROM java_db_lab.vehicle WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, vehicleId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vehicle with ID " + vehicleId + " has been deleted");
            } else {
                System.out.println("No vehicle found with ID " + vehicleId);
            }
        }
    }

    // Метод для видалення людини за ID
    public void deletePerson(int personId) throws SQLException {
        String sql = "DELETE FROM java_db_lab.person WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, personId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Person with ID " + personId + " has been deleted");
            } else {
                System.out.println("No person found with ID " + personId);
            }
        }
    }

}
