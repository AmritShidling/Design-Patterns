package thread;

class MyThread1 extends Thread{
    int total;
    MyThread1(int total){
        this.total = total;
    }
    public void run(){
        synchronized (this){
            for(int i = 0; i < 10; i++){
                total++;
            }
            this.notify();
        }

    }
}

public class WaitNotifyNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        MyThread1 myThread = new MyThread1(0);
        myThread.start();
        synchronized (myThread){
            myThread.wait();
            System.out.println(myThread.total);
            System.out.println("Got notified");
        }

    }
}
