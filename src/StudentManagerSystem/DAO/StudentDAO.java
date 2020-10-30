package StudentManagerSystem.DAO;

import StudentManagerSystem.db.DBManager1;
import StudentManagerSystem.mapper.StudentMapper;
import StudentManagerSystem.vo.Student;

import java.util.List;

public class StudentDAO {
    /**
     * 查询所有学生
     *
     * @return 查询到的包含所有学生的列表
     */
    public static List<Student> findAll() {
        String sql = "select * from studentDB";
        DBManager1 db = new DBManager1();
        StudentMapper mapper = new StudentMapper();
        List<Student> list = db.executeQuery(sql, null, mapper);
        return list;
    }

    /**
     * 根据学号查询学社
     *
     * @param StudentId 需要查询的学生学号
     * @return 查到的学生 或者 null
     */
    public static Student findByNo(int StudentId) {
        String sql = "select * from studentDB where studentNO =?";
        DBManager1 db = new DBManager1();
        Object params[] = {StudentId};
        StudentMapper mapper = new StudentMapper();
        List<Student> list = db.executeQuery(sql, params, mapper);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 添加学生
     *
     * @param stu 添加的学生
     * @return 执行结果
     */
    public static int save(Student stu) {
        String sql = "insert into studentDB values(?,?,?,?,?)";
        Object[] params = {stu.getSid(), stu.getSname(), stu.getSex(), stu.getAge(), stu.getPassword()};
        DBManager1 db = new DBManager1();
        return db.executeUpdate(sql, params);
    }

    /**
     * 更改学生信息
     *
     * @param stu 需要更改的学生
     * @return 执行结果
     */
    public static int merge(Student stu) {
        String sql = "update studentDB set studentName=?,sex=?,age=?,spassword=? where studentno = ?";
        Object[] params = {stu.getSname(), stu.getSex(), stu.getAge(), stu.getPassword(), stu.getSid()};
        DBManager1 db = new DBManager1();
        return db.executeUpdate(sql, params);
    }

    /**
     * 根据学号删除学生
     *
     * @param sid 需要删除的学生学号
     * @return 执行结果
     */
    public static int delete(int sid) {
        String sql = "delete from studentDB where sid = ?";
        Object[] params = {sid};
        DBManager1 db = new DBManager1();
        return db.executeUpdate(sql, params);
    }
}
