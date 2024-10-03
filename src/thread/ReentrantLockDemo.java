package thread;

import java.util.concurrent.locks.ReentrantLock;

class DisplayMessage{
    ReentrantLock lock = new ReentrantLock();
    public void display(String message){
        if(lock.tryLock())
        {
            for(int i = 0; i< 10; i++) System.out.println(message);
            lock.unlock();
        }
        else{
            System.out.println(Thread.currentThread().getName());
        }

    }
}
public class ReentrantLockDemo extends Thread{
    DisplayMessage d;
    public ReentrantLockDemo(DisplayMessage d){
        this.d =d;
    }
    public void run(){
        this.d.display("Hello");
    }
    public static void main(String[] args) {
        DisplayMessage d = new DisplayMessage();
        ReentrantLockDemo thread = new ReentrantLockDemo(d);

        thread.start();
        d.display("Hi");
    }
}
