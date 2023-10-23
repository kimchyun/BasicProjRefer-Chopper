package kim.chopper.bookstore.join;

public class CustomerVO {
    private int custId;
    private String name;
    private String address;
    private String phone;
    private String password;

    public CustomerVO() {
    }

    public CustomerVO(int custId, String password) {
        this.custId = custId;
        this.password = password;
    }

    public CustomerVO(int custId, String name, String address, String phone, String password) {
        this.custId = custId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.password = password;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 세션에 담긴 데이터를 초기화해주는 메소드
     * 호출시 로그인된 세션 정보 삭제
     */
    public void invalidate() {
        this.custId = 0;
        this.name = null;
        this.address = null;
        this.phone = null;
        this.password = null;
    }
    @Override
    public String toString() {
        return String.format("%d\t%s\t%s\t%s", custId, name, address, phone);
    }
}
