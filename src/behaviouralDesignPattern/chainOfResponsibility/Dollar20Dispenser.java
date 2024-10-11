package behaviouralDesignPattern.chainOfResponsibility;

public class Dollar20Dispenser implements DispenseChain{
    DispenseChain dispenseChain;
    @Override
    public void setNext(DispenseChain dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 20){
            int amount = currency.getAmount() / 20;
            int remainder = currency.getAmount() % 20;
            System.out.println("Dispensing "+ amount + " of $20");
            this.dispenseChain.dispense(new Currency(remainder));
        }
        else{
            this.dispenseChain.dispense(currency);
        }
    }
}
