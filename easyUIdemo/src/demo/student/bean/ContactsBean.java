package demo.student.bean;

/**
 * @date 2021/10/3 -17:31
 * 封装实体类ContactsBean
 * 紧急联系人实体类
 * 属性：姓名name，电话phone
 */

public class ContactsBean {
    private String name;
    private String phone;
    public ContactsBean(){
    }
    public ContactsBean(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ContactsBean{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
