package behaviouralDesignPattern.observerDesignPattern.observable;

import behaviouralDesignPattern.observerDesignPattern.observer.StockObserver;

public interface StockObservable {
    public void add(StockObserver observer);
    public void remove(StockObserver observer);
    public void notifyAllSubscribers();
    public void setStockCount(int count);
    public int getStockCount();
}
