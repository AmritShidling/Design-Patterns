import java.time.LocalDateTime;
import java.time.ZonedDateTime;

abstract class Animal{
    private int legs;
    public int getLes() {
        return this.legs;
    }
    public void setLegs(int legs){
        this.legs = legs;
    }
    public abstract String sounds();
}
class Dog extends Animal{
    public Dog(){
        super.setLegs(4);
    }

    @Override
    public String sounds(){
        return "Bow Bow";
    }

}

class Flight{
    private int seats = 1000;
    private int passengers;
    public Flight(){
//        seats = 0;
        passengers = 1000;
    }
    public int getSeats(){
        return this.seats;
    }
    public  int getPassengers(){
        return this.passengers;
    }
    public  void setSeats(int seats){
        this.seats = seats;
    }
    public   void setPassengers(int passengers){
        this.passengers = passengers;
    }
    private void notAllowed(){
        System.out.println("Seats are full....!");
    }
    public void addPassenger(){
        if(this.passengers == this.seats){
            notAllowed();
        }
        else
            this.passengers++;
    }
}

class Emerites extends Flight{
    private  int firstClassSeats = 4;

    public Emerites(){
        System.out.println(String.format("%d %d", this.getPassengers(), this.getSeats()));
    }
    public void bookFirstClass(){
        if(this.getPassengers() > this.firstClassSeats){
            System.out.println("Sorry cant book as we have only 4 seats");
        }
    }
}
public class Main {
    public static void main(String[] args) {

        Flight flight = new Flight();
        System.out.println(flight.getSeats());
        flight.setSeats(100);
        flight.setPassengers(100);
        flight.addPassenger();

        Flight emer = new Emerites();

//        Animal d = new Dog();
//        Dog dog = new Dog();
//        System.out.println(d.getLes());
//        System.out.println(dog  .getLes());
//        String a = "abcd";
//        String b = "ab";
//        String c = b + "cd";
//
//        System.out.println(a == b );
//        System.out.println(a.intern() == c.intern());
//        System.out.println(a.intern().getClass()  +" "+ a.getClass());


        ///************** String Format *********************///
//        String statement = String.format("I have %s apples", "hi");
//        System.out.println(statement);

//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime.getDayOfMonth());
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        System.out.println(zonedDateTime);
    }
}