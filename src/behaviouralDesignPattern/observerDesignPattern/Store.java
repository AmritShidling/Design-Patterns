package behaviouralDesignPattern.observerDesignPattern;

import behaviouralDesignPattern.observerDesignPattern.observable.IPhoneObservableImpl;
import behaviouralDesignPattern.observerDesignPattern.observable.StockObservable;
import behaviouralDesignPattern.observerDesignPattern.observer.EmailAlertObserver;
import behaviouralDesignPattern.observerDesignPattern.observer.MobileAlertObserver;

public class Store {

    public static void main(String[] args) {
        StockObservable iphoneObservable = new IPhoneObservableImpl();
        EmailAlertObserver observer1 = new EmailAlertObserver("test@gmail.com", iphoneObservable);
        MobileAlertObserver  observer2 = new MobileAlertObserver("test", iphoneObservable);
        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.setStockCount(100);
        iphoneObservable.setStockCount(0);
        iphoneObservable.setStockCount(100);
    }
}
