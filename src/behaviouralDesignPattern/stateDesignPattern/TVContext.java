package behaviouralDesignPattern.stateDesignPattern;

public class TVContext implements State {
    private State state;
    public void setState(State state){
        this.state = state;

    }
    public State getState(){
        return this.state;
    }
    @Override
    public void doAction() {
        state.doAction();
    }
}
