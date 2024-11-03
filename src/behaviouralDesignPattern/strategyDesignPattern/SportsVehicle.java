package behaviouralDesignPattern.strategyDesignPattern;

public class SportsVehicle extends Vehicle{

    public SportsVehicle() {
        super(new SportDriveStrategy());
    }
}
