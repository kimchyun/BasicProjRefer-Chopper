package kim.chopper.bookstore;

import kim.chopper.bookstore.join.CustomerVO;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import java.sql.SQLException;

public class BookstoreApplication {
    private static CustomerVO session = new CustomerVO();
    private static JdbcTemplate template = new JdbcTemplate();

    public static void main(String[] args) {
        new FrontController().process();
    }

    /**
     * 로그인한 정보를 가져오는 메소드
     * @return session 정보 반환
     */
    public static CustomerVO getSession() {
        return session;
    }

    /**
     * JDBC 관련 정보를 입력하는 곳
     * @return DB 정보를 담은 JDBCTemplate 객체 반환
     */
    public static JdbcTemplate getTemplate() {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL("jdbc:oracle:thin:@chopper.kim:1521:xe");
            dataSource.setUser("c##madang");
            dataSource.setPassword("madang");
            template.setDataSource(dataSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return template;
    }
}
