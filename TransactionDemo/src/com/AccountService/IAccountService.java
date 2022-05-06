package com.AccountService;

import java.sql.SQLException;

/**
 * @date 2021/6/25 -12:32
 * service操作（多原子操作）
 */
public interface IAccountService {
    //    转账
    void transfer(int fromCardId, int toCardId, int money) throws SQLException;
}
