package com.AccountService;

import com.AccountDaoImpl;
import com.IAccountDao;
import com.JDBCutil.JDBCutil;
import com.com.AccountBean;

import java.sql.SQLException;

/**
 * @date 2021/6/25 -12:34
 */
public class AccountServiceImpl implements IAccountService {
    @Override
    public void transfer(int fromCardId, int toCardId, int money) throws SQLException {
        IAccountDao dao = new AccountDaoImpl();
        //开启事务
        JDBCutil.beginTransaction();

        if (!(dao.isExtis(fromCardId))) {
            System.out.println("您输入的付款人不存在");
            return;
        }

        if (!(dao.isExtis(toCardId))) {
            System.out.println("您输入的收款人不存在");
            return;
        }

        //各种DML操作
        //转账 a减去1000  b加上1000
        //根据cardid查询相应的账号
        AccountBean fromAccount = dao.queryCountByCard(fromCardId);//付款方
        AccountBean toAccount = dao.queryCountByCard(toCardId);//收款方


//        判断收款方和付款方是否为同一个人
        if (fromAccount.getCardId() == toAccount.getCardId()) {
            JDBCutil.rollbackTransaction();
            System.out.println("您输入的收款人和付款人是同一个");
            return;
        }


//        转账
//        确保银行卡的余额大于转账金额
        if (fromAccount.getBalance() > money) {
//            付款方
            int fromBalance = fromAccount.getBalance() - money;
            fromAccount.setBalance(fromBalance);
            dao.updateAccount(fromAccount);


            int toBalance = toAccount.getBalance() + money;
            toAccount.setBalance(toBalance);
            toAccount.setCardId(toCardId);
            dao.updateAccount(toAccount);
            System.out.println("转账成功");
            //正常提交事务
            JDBCutil.commitTransaction();


        } else {
            JDBCutil.rollbackTransaction();
            System.out.println("余额不足");
        }
        JDBCutil.close();

        //结束事务（正常、失败）
    }
}
