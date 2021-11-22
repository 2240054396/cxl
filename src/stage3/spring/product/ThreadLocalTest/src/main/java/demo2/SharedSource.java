package demo2;

public class SharedSource {
    private int num = 5;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void decrease() throws InterruptedException {
        while (true) {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName()+" num="+num+" decrease!");
                Thread.sleep(100);
                num--;
            } else {
                System.out.println(Thread.currentThread().getName()+" "+num);
                break;
            }
        }
    }
}
