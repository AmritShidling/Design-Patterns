package thread;

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue{
    Queue<Integer> queue;
    int count;
    SharedQueue(){
        count = 1;
        queue = new LinkedList<>();
    }
}
class Producer extends Thread{
    SharedQueue sharedQueue;

    public Producer(SharedQueue queue){
        this.sharedQueue = queue;
    }

    public void run(){
        synchronized (sharedQueue){

            produce();
        }

    }
    public void produce(){
        for (int i = 0 ; i < 100; i++){
            sharedQueue.queue.offer(sharedQueue.count++);
            System.out.println("Produce "+ (sharedQueue.count -1));
            sharedQueue.notify();
        }

    }
}
class Consumer extends Thread{
    SharedQueue sharedQueue;
    public Consumer(SharedQueue queue){
        this.sharedQueue = queue;
    }

    public void run(){
        synchronized (sharedQueue){
            try {
                consume();
                System.out.println("Consume "+ this.sharedQueue.queue);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void consume() throws InterruptedException {
        if(sharedQueue.queue.size() == 0)
            sharedQueue.wait();
        sharedQueue.queue.poll();
    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();
        Producer producer = new Producer(sharedQueue);
        Consumer consumer = new Consumer(sharedQueue);
        producer.start();
        consumer.start();
    }
}
