package behaviouralDesignPattern.chainOfResponsibility;

public class Dollar50Dispenser implements DispenseChain{
    private DispenseChain chain;

    @Override
    public void setNext(DispenseChain dispenseChain) {
        this.chain = dispenseChain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount() >= 50){
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;
            System.out.println("Dispensing "+ num + " $50");
            if(remainder != 0) this.chain.dispense(new Currency(remainder));
        }
        else{
            this.chain.dispense(currency);
        }
    }
}
