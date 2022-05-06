package springmvc.restful.Bean;

/**
 * @date 2021/9/13 -21:13
 */
//员工实体类
public class Employee {
    private  Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    public Employee(){
    }
    public Employee(Integer id,String lastName,String email,Integer gender){
        this.id=id;
        this.lastName=lastName;
        this.email=email;
        this.gender=gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public Integer getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
