package behaviouralDesignPattern.stateDesignPattern;

public class TVStartState implements State{
    @Override
    public void doAction() {
        System.out.println("TV is terned ON");
    }
}
