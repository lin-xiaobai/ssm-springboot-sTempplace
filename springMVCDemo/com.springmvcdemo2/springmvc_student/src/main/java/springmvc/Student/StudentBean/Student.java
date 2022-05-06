package springmvc.Student.StudentBean;


/**
 * @date 2021/11/24 -16:34
 */
public class Student {
    private String name;
    private  String classroom;
    private String age;
    private String id;
    private String college;
    private  String major;

    public Student() {
    }


    public Student(String name, String classroom,String age, String id, String college, String major) {
        this.name = name;
        this.classroom = classroom;
        this.age = age;
        this.id = id;
        this.college = college;
        this.major = major;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classroom='" + classroom + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
