/**
 *  Java中创建线程的写法 3:
 *  使用匿名内部类 继承Thread
 *
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t = new Thread() { // 这是Thread子类但是没有名字，并且重写了run方法，并且t还指向这个匿名内部类。
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        t.start();
    }
}
