import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCInsertSelect {
    public static void main(String[] args) throws SQLException {
        /**
         * 创建数据源，描述一下服务器数据库在哪
         */
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java106?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("171612cgj");
        /**
         * 连接数据库
         */
        Connection connection = dataSource.getConnection();
        /**
         * 写sql语句
         */
        String sql = "select * from student,score where student.id = score.student_id";
        /**
         * JDBC中还要搭配一个对象来描述sql的情况
         */
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        /**
         * 正对sql的增删改搭配使用executeUpdate 其返回值是影响力几条数据
         * 查询则使用executeQuery  其返回值是一个集合结果
         */
        ResultSet set = preparedStatement.executeQuery();
        while(set.next()) {
            // next：光标该开始的时候指的是第一个的前一个，当移动到左后一个的时候就返回false；
            // getInt : 获取整形数据  getString: 获取字符串
            //里面的数据是我们列的名字
            int id = set.getInt("id");
            String name = set.getString("name");
            System.out.println(id + " " + name);
        }
        /**
         * 释放资源
         */
        set.close();
        preparedStatement.close();
        connection.close();
    }
}












