package behaviouralDesignPattern.chainOfResponsibility;

public class Dollar10Dispenser implements DispenseChain{
    DispenseChain dispenseChain;
    @Override
    public void setNext(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 10){
            int amount = currency.getAmount() / 10;
            int remainder = currency.getAmount() % 10;
            System.out.println("Dispensing "+ amount + " of $10");
//            this.dispenseChain.dispense(new Currency(remainder));
        }
//        else{
//            this.dispenseChain.dispense(currency);
//        }
    }
}
