package behaviouralDesignPattern.stateDesignPattern;

public class TVRemote {
    public static void main(String[] args) {
        TVContext tvContext = new TVContext();
        TVStartState startState = new TVStartState();
        TVStopState stopState = new TVStopState();
        tvContext.setState(startState);
        tvContext.doAction();
        tvContext.setState(stopState);
        tvContext.doAction();
    }
}
