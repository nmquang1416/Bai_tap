package module.product;

import java.sql.*;
import java.util.ArrayList;

public class ProductController implements ProductRepository {
    private final String MYSQL_CONNECTION = "jdbc:mysql://localhost:3306/java_exercise";
    private final String MYSQL_USER = "root";
    private final String MYSQL_PASSWORD = "";

    @Override
    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String SQL_STRING = "select id, name, price from prod";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_STRING);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Product product = new Product(id, name, price);
                products.add(product);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product findById( long id) {
        Product product =null;
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String SQL_STRING = "select id, name, price from products where id = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_STRING);
            while (resultSet.next()){
                int resultSetId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                product = new Product(id, name,price);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can not connect to database.");
            System.out.println(e.getMessage());
        }

        return product;
    }

    @Override
    public Product save(Product product) {
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String SQL_STRING = "insert into prod (name, price) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_STRING);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void deleteById() {
        try{
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String SQL_String = "\"delete from products where id = %d\", id";
            Statement statement = connection.createStatement();
            statement.execute(String.format(SQL_String));
            System.out.println("success");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
