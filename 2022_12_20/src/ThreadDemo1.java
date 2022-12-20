/**
 * Java中创建线程的写法 1:
 * 继承Thread类然后重写run方法
 */

class MyThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


public class ThreadDemo1 {

    public static void main(String[] args) {
       MyThread myThread = new MyThread(); // new 不会开启一个新线程
       myThread.start(); //开启一个新线程

       while(true) {
           System.out.println("hello main");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
