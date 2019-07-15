package crazy.codes.test.thread.multithreading;

/**
 * @Classname MultiThreadTest
 * @Description 不适用线程同步会出现的问题，多线程取款例子
 * @Date 2019/4/18 19:39
 * @Created by luojia
 */
public class MultiThreadTest {
    public static void main(String[] args) {
//      创建一个公共账户
        Account account=new Account("001",10000.0);
        Runnable runnable=new AccountRunnable(account);
        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
class AccountRunnable implements Runnable{
    private Account account;
    public AccountRunnable(Account account){
        this.account=account;
    }
    @Override
    public void run() {
        account.withdraw2(1000);
        System.out.println("取款1000成功，余额为："+account.getBalance());
    }
}
class Account{
    private String accountNo;
    private double balance;

    public Account(String accountNo,double balance){
        this.accountNo=accountNo;
        this.balance=balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //对当前账户做取款操作
    public void withdraw1(double money){
        double after=this.getBalance()-money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setBalance(after);
    }

//对当前账户做取款操作 同步代码块
    public void withdraw2(double money){
//        this对象锁
        synchronized (this){
            double after=this.getBalance()-money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }
    }

    //对当前账户做取款操作 同步方法
    public synchronized void withdraw3(double money){
        double after=this.getBalance()-money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setBalance(after);
    }
}