import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCinsertDemo {
    public static void main(String[] args) throws SQLException {
        //1:先去创建数据源，描述一下数据库在哪里
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java106?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        //2:和数据库进行连接
        Connection connection = dataSource.getConnection();
        //3:构造一个sql语句
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        String name = scanner.next();
        String sql = "insert into student values(?,?)";
        //jdbc中还要搭配一个对象来描述sql的情况
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        //4:针对sql的增,删,改使用executeUpdate()
        //这里的返回值是指影响了几行
        int ret = statement.executeUpdate();
        System.out.println(ret);
        //5:断开连接，释放资源
        statement.close();
        connection.close();
    }
}










