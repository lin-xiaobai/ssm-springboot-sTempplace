package CET4Web.DaoImpl;

import CET4Web.Bean.CET4Bean;
import CET4Web.DBPC.DBCP;
import CET4Web.IDao.IDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @date 2021/7/5 -23:43
 */
public class DaoImpl implements IDao {
    @Override
    public CET4Bean querys(CET4Bean cet) {
        //添加数据源
        QueryRunner runner = new QueryRunner(DBCP.getDataSourceBydbcp());
        String sql = "select * from etc4 where phone = ?";
        CET4Bean person = null;
        try {
//	将查询到的结果以对象的形式返回
            person = runner.query(sql, new BeanHandler<CET4Bean>(CET4Bean.class), cet.getPhone());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return person;
    }


    /*
     * count表示增加数据的个数
     *如果小于0则添加失败
     */
    @Override
    public int add(CET4Bean cet) {
        QueryRunner runner = new QueryRunner(DBCP.getDataSourceBydbcp());
        int count = -1;
        String sql = "insert into etc4(phone,password,idNumber,name) values(?,?,?,?)";
        try {
            count = runner.update(sql, new Object[]{cet.getPhone(), cet.getPassword(), cet.getIdNumber(), cet.getName()});
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;
    }

    //判断数据中的手机号码是否已经存在
    @Override
    public boolean isExist(CET4Bean cet) {
        return new DaoImpl().querys(cet) == null ? false : true;
    }
}
