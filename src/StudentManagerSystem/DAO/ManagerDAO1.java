package StudentManagerSystem.DAO;

import StudentManagerSystem.db.DBManager1;
import StudentManagerSystem.mapper.ManagerMapper;
import StudentManagerSystem.vo.Manager;

import java.util.List;

public class ManagerDAO1 {
    /**
     * 查询所有管理员
     *
     * @return 查询到的包含所有管理员的列表
     */
    public static List<Manager> findAll() {
        String sql = "select * from managerDB";
        DBManager1 db = new DBManager1();
        ManagerMapper mapper = new ManagerMapper();
        return (List<Manager>) db.executeQuery(sql, null,mapper);
    }

    /**
     * 添加管理员
     *
     * @param man 添加的管理员
     * @return 执行结果
     */
    public static int save(Manager man) {
        String sql = "insert into managerDB values(?,?,?)";
        Object[] params = {man.getId(), man.getName(), man.getPassword()};
        DBManager1 db = new DBManager1();
        return db.executeUpdate(sql, params);
    }

    /**
     * 更改管理员信息
     *
     * @param man 需要更改的学生
     * @return 执行结果
     */
    public static int merge(Manager man) {
        String sql = "update managerDB set mname=?,mpassword=? where mid = ?";
        Object[] params = {man.getName(), man.getPassword(), man.getId()};
        DBManager1 db = new DBManager1();
        return db.executeUpdate(sql, params);
    }

    /**
     * 根据管理员编号删除管理员
     *
     * @param id 需要删除的管理员编号
     * @return 执行结果
     */
    public static int delete(int id) {
        String sql = "delete from managerDB where mid = ?";
        Object[] params = {id};
        DBManager1 db = new DBManager1();
        return db.executeUpdate(sql, params);
    }

    /**
     * 验证管理员登录
     */
    public static List<Manager> managerLogin(String Mid, String password){
        String  sql = "select * from managerDB where  MID = ? and MPASSWORD = ?";
        int mid = Integer.parseInt(Mid);
        Object[]params = {mid,password};
        DBManager1 db = new DBManager1();
        ManagerMapper mapper = new ManagerMapper();
        return (List<Manager>) db.executeQuery(sql, params,mapper);

    }
}
