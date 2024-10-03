import java.util.ArrayList;
import java.util.List;

interface Observer{
    public void notify(String content);
}
interface Subject{
    public void registerObserver(Observer observer);
    public void notifyObserver();
    public void removeObserver(Observer observer);
}

class WebsiteContent implements Subject{
    List<Observer> observers;
    String content;
    public WebsiteContent(){
        observers = new ArrayList<>();
    }
    public void registerObserver(Observer observer){
        observers.add(observer);
    }
    @Override
    public void notifyObserver() {

        for(Observer observer: observers){
            observer.notify(this.content);
        }
    }
    public void updateContent(String content){
        this.content = content;
        notifyObserver();
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}

class ContentSubscriber implements Observer{
    String content;
    public void  notify(String content){
        this.content = content;
        System.out.println("updated content to = "+ this.content);
    }
}
public class ObserverDesignPattern {
    public static void main(String[] args) {
        WebsiteContent subject = new WebsiteContent();
        Observer observer = new ContentSubscriber();
        subject.registerObserver(observer);
        subject.updateContent("updated content");
    }
}
