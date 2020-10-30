package StudentManagerSystem.mapper;

import StudentManagerSystem.vo.Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerMapper implements IMapper{
    @Override
    public List<Manager> map(ResultSet rst) throws SQLException {
        List<Manager> list = new ArrayList<>();
        while (rst.next()){
            Manager man  = new Manager();
            man.setId(rst.getInt("MID"));
            man.setName(rst.getString("MNAME"));
            man.setPassword(rst.getString("MPASSWORD"));
            list.add(man);
        }
        return list;
    }
}
