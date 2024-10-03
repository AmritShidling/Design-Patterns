package thread;

class T1 extends Thread{
    Thread t2;
    public void assign(Thread t2){
        this.t2 = t2;
    }
    public void run(){
        try {
            t2.join();
        }
        catch (InterruptedException ex){
            System.out.println(ex);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        }
    }
}
class T2 extends Thread{
    Thread t1;
    public void assign(Thread t1){
        this.t1 = t1;
    }
    public void run() {
        try {
            t1.join();
        }
        catch (InterruptedException ex){
            System.out.println(ex);
        }

        for(char a = 'a'; a < 'k'; a++){
            System.out.println(a);
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.assign(t2);
        t2.assign(t1);
        t1.start();
        t2.start();

    }
}
