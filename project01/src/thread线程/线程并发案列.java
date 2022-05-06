package thread线程;

/**
 * @date 2021/4/14 -17:21
 * 使用线程同步机制，多线程对同一个账号进行取款，出现线程安全问题
 * 数据错误
 */
public class 线程并发案列 {
    public static void main(String[] args) {
        Account a1 = new Account("t1", 10000);
        Thread t1 = new AccountThread(a1);
        Thread t2 = new AccountThread(a1);
//        Account a2=new Account("t2",10000);
//        Thread t3=new AccountThread(a2);
        t1.start();
        t2.start();
//        t3.start();

    }
}

//创建一个账号类
class Account {
    private String name;
    private double money;

    public Account() {
    }

    public Account(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    //    定义一个取钱的方法
    public void giveMoney(double money) {
        double before = this.getMoney();
        double after = before - money;
//        传入的参数是共享对象
//        this表示的是当前对象
        synchronized (this) {
            try {
//                模拟网络延迟
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            this.setMoney(after);
        }
//
    }
}

class AccountThread extends Thread {
    private Account act;

    //    通过构造方法传递过来账号的对象
    public AccountThread(Account act) {
        this.act = act;
    }

    @Override
    public void run() {
//        调用取钱方法
        act.giveMoney(5000);
        System.out.println(Thread.currentThread().getName() + "对" + act.getName() + "取款成功，余额" + act.getMoney());
    }
}