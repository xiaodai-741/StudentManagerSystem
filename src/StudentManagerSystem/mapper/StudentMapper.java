package StudentManagerSystem.mapper;

import StudentManagerSystem.vo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper implements IMapper{
    @Override
    public List<Student> map(ResultSet rst) throws SQLException {
        List<Student> list = new ArrayList<>();
        while (rst.next()){
            Student stu  = new Student();
            stu.setSid(rst.getInt("STUDENTNO"));
            stu.setSname(rst.getString("STUDENTNAME"));
            stu.setSex(rst.getString("SEX"));
            stu.setAge(rst.getInt("AGE"));
            stu.setPassword(rst.getString("SPASSWORD"));
            list.add(stu);
        }
        return list;
    }
}
