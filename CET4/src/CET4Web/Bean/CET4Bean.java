package CET4Web.Bean;

/**
 * @date 2021/7/5 -23:43
 */
public class CET4Bean {
    private String phone;
    private String password;
    private String idNumber;
    private String name;

    public CET4Bean() {
    }

    public CET4Bean(String phone, String password, String idNumber, String name) {
        this.phone = phone;
        this.password = password;
        this.idNumber = idNumber;
        this.name = name;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
