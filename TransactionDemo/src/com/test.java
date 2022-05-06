package com;

import com.AccountService.AccountServiceImpl;
import com.AccountService.IAccountService;

import java.sql.SQLException;

/**
 * @date 2021/6/25 -13:06
 */
public class test {
    public static void main(String[] args) {
        IAccountService accountService = new AccountServiceImpl();
        try {
            accountService.transfer(123, 56, 1000);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
