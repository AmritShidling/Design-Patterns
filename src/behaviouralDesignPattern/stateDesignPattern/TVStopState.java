package behaviouralDesignPattern.stateDesignPattern;

public class TVStopState implements State{
    @Override
    public void doAction() {
        System.out.println("TV is terned OFF");
    }
}