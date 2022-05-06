package student.pojo;

/**
 * @date 2021/12/4 -13:32
 */

public class Student {
    private String sname;
    private int sage;
    private  String sid;
    private String scolleage;
    private String smajor;
    public  Student(){}

    public Student(String sname, int sage, String sid, String scolleage, String smajor) {
        this.sname = sname;
        this.sage = sage;
        this.sid = sid;
        this.scolleage = scolleage;
        this.smajor = smajor;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getScolleage() {
        return scolleage;
    }

    public void setScolleage(String scolleage) {
        this.scolleage = scolleage;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sname='" + sname + '\'' +
                ", sage=" + sage +
                ", sid='" + sid + '\'' +
                ", scolleage='" + scolleage + '\'' +
                ", smajor='" + smajor + '\'' +
                '}';
    }
}
