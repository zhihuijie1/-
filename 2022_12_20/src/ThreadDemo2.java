/**
 * Java中创建线程的写法 2:
 * 实现 Runnable接口
 *
 * 将任务与线程分离了，任务是任务，线程是线程
 * 实现了解耦合，
 */
// Runnable是描述一个要执行的任务    run则是执行这个任务的细节
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello runnable");
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        // 这是描述了一个任务
        MyRunnable myRunnable = new MyRunnable();
        // 把任务交给线程来执行
        Thread t = new Thread(myRunnable);
        t.start();
    }
}
