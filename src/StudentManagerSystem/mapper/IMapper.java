package StudentManagerSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IMapper {
    public List map(ResultSet rst) throws SQLException;
}
