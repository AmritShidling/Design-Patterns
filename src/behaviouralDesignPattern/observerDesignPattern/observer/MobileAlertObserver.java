package behaviouralDesignPattern.observerDesignPattern.observer;

import behaviouralDesignPattern.observerDesignPattern.observable.StockObservable;

public class MobileAlertObserver implements StockObserver{
    String username;
    StockObservable observable;
    public MobileAlertObserver(String username, StockObservable observable) {
        this.username = username;
        this.observable = observable;
    }
    @Override
    public void update() {
        sendSMS();
    }
    private void sendSMS(){
        System.out.println("Stock is present now!");
    }
}
