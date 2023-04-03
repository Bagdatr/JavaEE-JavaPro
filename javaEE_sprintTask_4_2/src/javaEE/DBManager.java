package javaEE;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    static{
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sprintTask_4_2","postgres","9187");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean addItem(Item item){
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into items(name,description,price) values(?,?,?)");
            stmt.setString(1,item.getName());
            stmt.setString(2,item.getDescription());
            stmt.setDouble(3,item.getPrice());
            rows = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;
    }
    public static ArrayList<Item> getAllItems(){
        ArrayList<Item>items = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from items");
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));
                items.add(item);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
    public static boolean addUser(User user){
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into users(email,password) values(?,?)");
            stmt.setString(1,user.getEmail());
            stmt.setString(2,user.getPassword());
            rows = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;
    }
    public static User getUser(String email){
        User user = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from users where email = ?");
            stmt.setString(1,email);
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
