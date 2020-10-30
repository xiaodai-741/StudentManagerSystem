package StudentManagerSystem.db;

import StudentManagerSystem.mapper.IMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 连接数据库准备类
 */
public class DBManager1 {
    /**
     * 获得Connection连接
     *
     * @return Connection 连接
     * @throws SQLException sql 异常
     */
    public static Connection getConn() throws ClassNotFoundException, SQLException {
        return DBHelper1.getconn();
    }

    /**
     * SQL DQL语句执行
     *
     * @param sql    需要执行的DQL语句
     * @param params 操作的属性
     * @return 操作数据库的行数
     */
    public int executeUpdate(String sql, Object[] params) {
        try {
            try {
                try (Connection conn = getConn();
                     PreparedStatement prs = conn.prepareStatement(sql)
                ) {
                    if (params != null) {
                        for (int i = 0; i < params.length; i++) {
                            prs.setObject(i + 1, params[i]);
                        }
                    }
                    return prs.executeUpdate();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 执行 SQL DML 语句
     *
     * @param sql    需要执行的DML语句
     * @param params 需要操作的属性
     * @return 结果集列表
     */
    public List executeQuery(String sql, Object[] params, IMapper mapper) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            conn = getConn();
            pst = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            rst = pst.executeQuery();
            return mapper.map(rst);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rst != null) {
                    rst.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


}