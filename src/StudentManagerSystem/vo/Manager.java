package StudentManagerSystem.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Manager implements Serializable {
    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SuppressWarnings("unused")
    public Manager() {
        super();
    }

    public Manager(int id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "管理员编号:"+id+"\t管理员姓名:"+name;
    }
}

