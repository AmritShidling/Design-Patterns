package behaviouralDesignPattern.observerDesignPattern.observable;

import behaviouralDesignPattern.observerDesignPattern.observer.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObservableImpl implements StockObservable{
    List<StockObserver> iphoneObserver = iphoneObserver = new ArrayList<>();
    int count = 0;
    @Override
    public void add(StockObserver observer) {
        iphoneObserver.add(observer);
    }

    @Override
    public void remove(StockObserver observer) {
        iphoneObserver.remove(observer);
    }

    @Override
    public void notifyAllSubscribers() {
        for(StockObserver observer: iphoneObserver){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int count) {
        if(this.count == 0 && count > 0){
            notifyAllSubscribers();
        }
        this.count = count;
    }

    @Override
    public int getStockCount() {
        return this.count;
    }
}
