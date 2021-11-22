package demo2;

public class ThreadLocalDemo {
    static ThreadLocal<SharedSource> threadLocal = new ThreadLocal<SharedSource>();

    public static void main(String[] args) {
    final SharedSource sharedSource = new SharedSource();
        System.out.println(sharedSource);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                threadLocal.set(sharedSource);
                System.out.println(threadLocal.get());
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                threadLocal.set(sharedSource);
                System.out.println(threadLocal.get());
            }
        });
        thread.start();
        thread1.start();
    }
}
