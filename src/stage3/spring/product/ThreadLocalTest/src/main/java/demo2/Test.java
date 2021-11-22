package demo2;

public class Test {
    public static void main(String[] args) {
        final SharedSource sharedSource=new SharedSource();
        new Thread(new Runnable() {
            public void run() {
                try {
                    sharedSource.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    sharedSource.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
