package thread;

public class ThreadGroup {
    public static void main(String[] args) {
        java.lang.ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        System.out.println(system.activeCount());
        Thread[] threads = new Thread[system.activeCount()];
        system.enumerate(threads);
        for (Thread thread: threads){
            System.out.println(thread.getName());
        }
    }
}
