package com;

import com.JDBCutil.JDBCutil;
import com.com.AccountBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @date 2021/6/25 -11:41
 * 原子操作
 */
public class AccountDaoImpl implements IAccountDao {
    @Override
    public AccountBean queryCountByCard(int cardId) throws SQLException {
//        无参是手动提交事务
        QueryRunner runner = new QueryRunner();
//        获取链接对象
        Connection conn = JDBCutil.getConnection();
        String sql = "select * from account where cardid= ? ";

//       BeanHandler：结果集以对象的形式返回

        AccountBean account = runner.query(conn, sql, new BeanHandler<AccountBean>(AccountBean.class), cardId);

        return account;
    }

    @Override
    public void updateAccount(AccountBean account) {
        QueryRunner runner = new QueryRunner();
        Connection conn = JDBCutil.getConnection();
        String sql = "update account set balance =? where cardid=?";
        int count = -1;
        try {
            count = runner.update(conn, sql, new Object[]{account.getBalance(), account.getCardId()});
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //判断输入的卡号是否存在
    @Override
    public boolean isExtis(int cardId) throws SQLException {
        boolean falg = false;
        AccountBean bean = queryCountByCard(cardId);
        if (bean == null) {
            falg = false;
        } else {
            falg = true;
        }

        return falg;
    }

    public static void main(String[] args) throws SQLException {
        AccountDaoImpl accountDao = new AccountDaoImpl();
        AccountBean bean = accountDao.queryCountByCard(123);
        System.out.println(bean);
    }
}
