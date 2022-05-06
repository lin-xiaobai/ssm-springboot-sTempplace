package com;

import com.com.AccountBean;

import java.sql.SQLException;

/**
 * @date 2021/6/25 -11:33
 * 接口
 */
public interface IAccountDao {
    //    根据卡号查名字
    AccountBean queryCountByCard(int cardId) throws SQLException;

    //  修改账号
    void updateAccount(AccountBean account);

    boolean isExtis(int cardId) throws SQLException;
}
