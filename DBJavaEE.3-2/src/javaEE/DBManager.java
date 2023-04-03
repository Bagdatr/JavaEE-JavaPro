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
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_task_3_2","postgres","9187");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean addStudent(Student student){
        int rows = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into students(name,surname,birthdate,city)values(?,?,?,?)");
            stmt.setString(1,student.getName());
            stmt.setString(2,student.getSurname());
            stmt.setString(3,student.getBirthdate());
            stmt.setString(4,student.getCity());
            rows =stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows > 0;
    }

    public static Student getStudent(Long id){
        Student student = null;
        try {
            PreparedStatement stmt =connection.prepareStatement("select * from students where id = ?");
            stmt.setLong(1,id);
            ResultSet resultSet =stmt.executeQuery();
            if(resultSet != null){
                if(resultSet.next()){
                    student = new Student();
                    student.setId(resultSet.getLong("id"));
                    student.setName(resultSet.getString("name"));
                    student.setSurname(resultSet.getString("surname"));
                    student.setBirthdate(resultSet.getString("birthdate"));
                    student.setCity(resultSet.getString("city"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    public static ArrayList<Student> getAllStudents(){
        ArrayList<Student>students = new ArrayList<>();
        try {
            PreparedStatement stmt =connection.prepareStatement("select * from students");
            ResultSet resultSet =stmt.executeQuery();
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setBirthdate(resultSet.getString("birthdate"));
                student.setCity(resultSet.getString("city"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
