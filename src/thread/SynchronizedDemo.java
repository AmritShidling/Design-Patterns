package thread;

import java.util.concurrent.locks.Lock;

class Display{

    public void displayMessage(String message){
        synchronized (this) {
            for(int i = 0; i < 10; i++)
                System.out.println(message);
        }

    }
}

class MessageThread extends Thread{
    String message;
    Display display;
    public MessageThread(String message, Display display){
        this.message = message;
        this.display = display;
    }

    public void run(){

            display.displayMessage(this.message);

    }
}
public class SynchronizedDemo {
    public static void main(String[] args) {
        Display d= new Display();
        Thread t1 = new MessageThread("Hi", d);
        Thread t2 = new MessageThread("Hello", d);
        t1.start();
        t2.start();
    }
}
