package kim.chopper.bookstore.order;

import java.sql.Timestamp;
import java.time.LocalDate;

public class OrderVO {
    private int orderId;
    private int customerId;
    private int bookId;
    private String bookName;
    private int salePrice;
    private Timestamp orderDate;

    public OrderVO() {
    }

    public OrderVO(int customerId, int bookId, int salePrice) {
        this.customerId = customerId;
        this.bookId = bookId;
        this.salePrice = salePrice;
    }

    public OrderVO(int customerId, int custId, int bookId, String bookName, int salePrice, Timestamp orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.salePrice = salePrice;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return String.format("%d\t%s\t%d\t%s", orderId, bookName, salePrice, orderDate);
    }
}
