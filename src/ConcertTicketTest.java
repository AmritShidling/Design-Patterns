import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class ConcertTicketSystem{
    private final String concertName;
    private final AtomicInteger totalAvailableSeats;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    public ConcertTicketSystem(String concertName, int totalAvailableSeats) {
        this.concertName = concertName;
        this.totalAvailableSeats = new AtomicInteger(totalAvailableSeats);
    }
    public boolean bookTicket(int quantity){
        reentrantLock.lock();
        try{
            if(totalAvailableSeats.get() >= quantity){
                Thread.sleep(100);
                totalAvailableSeats.addAndGet(-quantity);
                System.out.println("booked successfully");
                return true;
            }
            else{
                System.out.println(Thread.currentThread().getName() + " Purchase failed");
                return false;
            }
        }
        catch (InterruptedException ex){
            Thread.currentThread().interrupt();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }
    public int getTotalAvailableSeats(){
        return totalAvailableSeats.get();
    }
    public String getConcertName(){
        return concertName;
    }
}
public class ConcertTicketTest {
    public static void main(String[] args) {
        ConcertTicketSystem concertTicketSystem = new ConcertTicketSystem("Rock", 10);
        Runnable purchaseTask = () -> {
            for (int i = 0; i < 4; i++){
                concertTicketSystem.bookTicket(1);
            }
        };

        Thread t1 = new Thread(purchaseTask, "Thread1");
        Thread t2 = new Thread(purchaseTask, "Thread2");
        Thread t3 = new Thread(purchaseTask, "Thread3");
        Thread t4 = new Thread(purchaseTask, "Thread4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(concertTicketSystem.getTotalAvailableSeats());
    }
}
