package module.user;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MySqlUserRepository implements UserRepository{
    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
    private final String MYSQL_CONNECTION = "jdbc:mysql://localhost:3306/java_exercise";
    private final String MYSQL_USER = "root";
    private final String MYSQL_PASSWORD = "";

    @Override
    public ArrayList<User> findAll() {
        ArrayList<User> users =new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION,MYSQL_USER,MYSQL_PASSWORD);
            String SQL_String = "select * from users where status = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_String);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long id = resultSet.getLong("id");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                String identityCard = resultSet.getString("identity_card");
                String phone = resultSet.getString("phone");
                String dob = resultSet.getString("dob");
                int status = resultSet.getInt("dob");

                User user = new User();
                user.setId(id);
                user.setUserName(userName);
                user.setPassword(password);
                user.setFullName(fullName);
                user.setIdentityCard(identityCard);
                user.setPhone(phone);
                user.setDob(LocalDate.parse(dob, formatter));
                user.setStatus(status);
                users.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Có lỗi xảy ra, vui lòng thử lại sau.");
        }
        return null;
    }

    @Override
    public User findById(long id) {
        User user = null;
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION,MYSQL_USER,MYSQL_PASSWORD);
            String SQL_String ="select * from users where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_String);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                String identityCard = resultSet.getString("identity_card");
                String phone = resultSet.getString("phone");
                String dob = resultSet.getString("dob");
                int status = resultSet.getInt("dob");

                user = new User();
                user.setId(id);
                user.setUserName(userName);
                user.setPassword(password);
                user.setFullName(fullName);
                user.setIdentityCard(identityCard);
                user.setPhone(phone);
                user.setDob(LocalDate.parse(dob, formatter));
                user.setStatus(status);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Có lỗi xảy ra, vui lòng thử lại sau.");
        }
        return user;
    }

    @Override
    public User save(User user) {
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION,MYSQL_USER,MYSQL_PASSWORD);
            String SQL_String = "insert into users (username, password, full_name, identity_card, phone, dob, status) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_String);

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getIdentityCard());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getDob().toString());
            preparedStatement.setInt(7, user.getStatus());
            preparedStatement.execute();
            System.out.println("success");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String SQL_String = "";
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
