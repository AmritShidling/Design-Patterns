package behaviouralDesignPattern.stateDesignPattern;

public class TVRemoteBasic {
    private String state = "";
    public void setState(String state){
        this.state = state;
    }

    public void doAction(){
        if(state.equalsIgnoreCase("ON")){
            System.out.println("TV Terned On");
        }
        else{
            System.out.println("TV Terned Off");
        }
    }

    public static void main(String[] args) {
        TVRemoteBasic remote = new TVRemoteBasic();
        remote.setState("ON");
        remote.doAction();
        remote.setState("OFF");
        remote.doAction();
    }
}
