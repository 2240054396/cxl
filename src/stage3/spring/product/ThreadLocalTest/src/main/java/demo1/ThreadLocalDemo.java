package demo1;

public class ThreadLocalDemo {
    private static ThreadLocal<String> localVar=new ThreadLocal<String>();
    static void print(String str){
        System.out.println(str+":"+localVar.get());
        localVar.remove();
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                ThreadLocalDemo.localVar.set("local_A");
                print("A");
                System.out.println("after remove "+localVar.get());
            }
        },"A").start();
        Thread.sleep(1000);
        new Thread(new Runnable() {
            public void run() {
                ThreadLocalDemo.localVar.set("local_B");
                print("B");
                System.out.println("after remove "+localVar.get());
            }
        },"B").start();
    }
}
