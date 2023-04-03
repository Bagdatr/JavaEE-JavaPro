package kz.bitlab.springmvc;

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
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/spring-mvc-database","postgres","9187");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean addItem(Item item){
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into items(name,price,amount)values(?,?,?)");
            stmt.setString(1,item.getName());
            stmt.setInt(2,item.getPrice());
            stmt.setInt(3,item.getAmount());
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
            ResultSet resultSet =stmt.executeQuery();
            while(resultSet.next()){
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getInt("price"));
                item.setAmount(resultSet.getInt("amount"));
                items.add(item);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
}
