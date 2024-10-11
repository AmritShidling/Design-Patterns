package behaviouralDesignPattern.chainOfResponsibility;

public interface DispenseChain {
    void setNext(DispenseChain dispenseChain);
    void dispense(Currency currency);
}
