package kim.chopper.bookstore.order;

import kim.chopper.bookstore.BookstoreApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderDAO {
    private static OrderDAO instance = new OrderDAO();
    public static OrderDAO getInstance() {
        return instance;
    }
    private OrderDAO() {}

    private JdbcTemplate template = BookstoreApplication.getTemplate();

    public List<OrderVO> findAll(int custId) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        builder.append("    A.ORDER_ID, ");
        builder.append("    A.BOOK_ID, ");
        builder.append("    B.BOOK_NAME, ");
        builder.append("    A.SALE_PRICE, ");
        builder.append("    A.ORDER_DATE ");
        builder.append("FROM ");
        builder.append("    ORDERS A ");
        builder.append("    INNER JOIN ");
        builder.append("        BOOK B ");
        builder.append("    ON A.BOOK_ID = B.BOOK_ID ");
        builder.append("WHERE ");
        builder.append("    A.CUSTOMER_ID = ? ");
        builder.append("ORDER BY ");
        builder.append("    A.ORDER_DATE ");
        String sql = builder.toString();
        return template.query(sql, new BeanPropertyRowMapper<>(OrderVO.class), custId);
    }

    public int orderBook(OrderVO vo) {
        String sql = "INSERT INTO ORDERS (CUSTOMER_ID, BOOK_ID, SALE_PRICE) VALUES (?, ?, ?)";
        return template.update(sql, vo.getCustomerId(), vo.getBookId(), vo.getSalePrice());
    }
}
