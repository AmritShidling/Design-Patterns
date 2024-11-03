package behaviouralDesignPattern.strategyDesignPattern;


public class Vehicle {
    DriveStrategy driveStrategy;
    public Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }

    public static void main(String[] args) {
        Vehicle sportCar = new SportsVehicle();
        sportCar.drive();

    }
}
