package behaviouralDesignPattern.strategyDesignPattern;

public class SportDriveStrategy implements DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Driving Sports Style");
    }
}
