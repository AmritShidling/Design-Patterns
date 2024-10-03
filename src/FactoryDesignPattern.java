

interface Vehicle{
    public String drive();
}
class Truck implements Vehicle{
    public String drive() {
        return "Delivering by land";
    }
}
class Boat implements Vehicle{
    public String drive(){
        return "Delivering by sea";
    }
}
class Plane implements Vehicle{
    public String drive(){
        return "Delivering by air";
    }
}
class VehicleFactory{
    public static Vehicle getVehicle(String vehicleType){
        switch (vehicleType){
            case "boat":
                return new Boat();
            case "plane":
                return new Plane();
            case  "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type" );

        }
//        return null;
    }
}
public class FactoryDesignPattern {


    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle plane = vehicleFactory.getVehicle("plane");
        System.out.println(plane.drive());
    }
}
