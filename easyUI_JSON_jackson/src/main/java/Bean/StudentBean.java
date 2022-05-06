package Bean;

/**
 * @date 2021/10/3 -19:43
 * 封装实体类ContactsBean
 * 紧急联系人实体类
 * 属性：姓名name，电话phone
 */

public class StudentBean {
    private String id;
    private String name;
    private String grade;
    private String major;
    private String classname;
    //    紧急联系人
    private ContactsBean person;
    public StudentBean(){
    }
    public StudentBean(String id,String name,String grade,String major,String classname){
        this.id=id;
        this.name=name;
        this.grade=grade;
        this.major=major;
        this.classname=classname;

    }
    public StudentBean(String id,String name,String grade,String major,String classname,ContactsBean person){
        this.id=id;
        this.name=name;
        this.grade=grade;
        this.major=major;
        this.classname=classname;
        this.person=person;
    }

    public ContactsBean getPerson() {
        return person;
    }

    public void setPerson(ContactsBean person) {
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}
