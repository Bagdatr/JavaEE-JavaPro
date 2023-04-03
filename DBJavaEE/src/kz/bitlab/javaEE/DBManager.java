package kz.bitlab.javaEE;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    static{
        try{
            Class.forName("org.postgresql.Driver");// это автоматический метод (поэтому он статичный) вызова подключения к базе данных
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","postgres","9187");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//все, что лежит в static - это подключение к базе данных
    public static boolean addItem(Item item){
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into items(name,price,amount)values(?,?,?)");
            stmt.setString(1,item.getName());//первый индекс - это первый вопросительный знак в values. теперь этот метод будет заменять этот вопросик на item name
            stmt.setInt(2,item.getPrice());
            stmt.setInt(3,item.getAmount());
            rows = stmt.executeUpdate();//с помощью этого метода мы отправляем запакованный объект в базу данных. Это поезд, который едет только в одну сторону - обновление, удаление, добавление
            stmt.close();//обязательно нужно закрывать "дверь" stmt после отправки объекта в базу данных

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;//если мой rows дошел до результата, то это true
    }
    public static ArrayList<Item>getAllItems(){
        ArrayList<Item>items = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from items");//* означает all("ВСЁ")
                ResultSet resultSet = stmt.executeQuery();//Это поезд, который едет и возвращается обратно с чем-то - 1. пошел, 2.взял, 3. вернулся с чем-то и сохранил
            while(resultSet.next()){//метод next - это как foreach цикл
                Item item = new Item();
                item.setId(resultSet.getLong("id"));//это мы добавили после начала новой задачи, т.к. теперь нужно проваливаться в "детали" каждого товара
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

    public static Item getItem(Long id){ // данный метод создаем, чтобы вытаскивать по id один из товаров из БД
        Item item = null;
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from items where id = ?");//вытащи все из таблицы items, где id равно вопросу:)
            stmt.setLong(1,id);
            ResultSet resultSet = stmt.executeQuery();//пошел туда, взял, и вернулся с ответом - поэтому использует Query
            if(resultSet != null){
                if(resultSet.next()){
                    item = new Item();
                    item.setId(resultSet.getLong("id"));
                    item.setName(resultSet.getString("name"));
                    item.setPrice(resultSet.getInt("price"));
                    item.setAmount(resultSet.getInt("amount"));
                }
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return item;//возвращается объект, если что-то в нем есть. если нет и он равен null, то возвращается "ничего"
    }

    public static boolean updateItem(Item item){
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("update items set name = ?, price = ? " +
                    ", amount = ? where id = ? ");
            stmt.setString(1,item.getName());
            stmt.setInt(2,item.getPrice());
            stmt.setInt(3,item.getAmount());
            stmt.setLong(4,item.getId());
            rows = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;
    }
    public static boolean removeItem(Long id){
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from items where id = ?");
            stmt.setLong(1,id);
            rows = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;
    }
}
