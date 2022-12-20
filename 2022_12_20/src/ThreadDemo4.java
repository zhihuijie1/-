public class ThreadDemo4 {
    /**
     * 使用匿名内部类 实现Runnable
     */

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() { // 此处是创建一个匿名类来描述Runnable，并将这个任务交给线程
            @Override
            public void run() {
                System.out.println("hello");
            }
        });
        t.start();
    }
}
