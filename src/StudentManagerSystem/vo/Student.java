package StudentManagerSystem.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {
    private int sid;
    private String sname;
    private String sex;
    private int age;
    private String password;

    public int getSid() {
        return sid;
    }

    @SuppressWarnings("unused")
    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SuppressWarnings("unused")
    public Student() {
        super();
    }

    public Student(int sid, String sname, String sex, int age, String password) {
        super();
        this.sid = sid;
        this.sname = sname;
        this.sex = sex;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "学生姓名为:" + getSname() + " 学号为:" + getSid() + " " + "性别为:"
                + getSex() + " 年龄为:" + getAge() + " 密码为:" + getPassword();
    }
}
