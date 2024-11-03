package behaviouralDesignPattern.observerDesignPattern.observer;

import behaviouralDesignPattern.observerDesignPattern.observable.StockObservable;

public class EmailAlertObserver implements StockObserver{
    String email;
    StockObservable observable;
    public EmailAlertObserver(String email, StockObservable observable) {
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail();
    }
    private void sendEmail(){
        System.out.println("Stock is present now! " + email);
    }
}
