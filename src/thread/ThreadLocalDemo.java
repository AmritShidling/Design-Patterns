package thread;

class MyThread extends Thread{
    public static InheritableThreadLocal tl = new InheritableThreadLocal(){
        @Override
        public Object get() {
            return "pp";
        }
};
    public void run(){
        tl.set("Test");
        System.out.println(tl.get());
        MyThreadChild myThreadChild = new MyThreadChild();
        myThreadChild.start();
    }
}

class MyThreadChild extends MyThread{
    public void run(){
        System.out.println(tl.get());
    }
}
public class ThreadLocalDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
//        MyThreadChild mtc = new MyThreadChild();
        mt.start();
//        mtc.start();
    }
}
