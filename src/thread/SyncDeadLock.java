package thread;

class A{
    public synchronized void d1(B b){
        System.out.println("Thread 1 starts execute");
        try{
            Thread.sleep(6000);
        }
        catch (InterruptedException ex){}
        System.out.println("Thread trying to call thread.B");
        b.last();
    }
    public synchronized void last(){
        System.out.println("inside last thread.A" );
    }
}
class B{
    public synchronized void d1(A a){
        System.out.println("Thread 2 starts execution");
        try{
            Thread.sleep(6000);
        }
        catch (InterruptedException ex){}
        a.last();
    }
    public synchronized void last(){
        System.out.println("inside last thread.A" );
    }
}
public class SyncDeadLock extends Thread{
    A a = new A();
    B b = new B();

    public void m1(){
        this.start();
        a.d1(b);
    }
    public void run(){
        b.d1(a);
    }
    public static void main(String[] args) {
        SyncDeadLock s = new SyncDeadLock();
        s.m1();
    }
}
