package structuralDesignPattern;
import java.lang.*;
interface Pizza{
    public abstract String getDescription();
    public abstract double getPrice();
}
class PlainPizza implements Pizza{

    @Override
    public String getDescription() {
        return "This is Plain Pizza";
    }

    public double getPrice(){
        return 2.0;
    }
}

abstract class PizzaDecorator implements Pizza {
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza){
        this.decoratedPizza = pizza;
    }

    @Override
    public String getDescription(){
        return this.decoratedPizza.getDescription();
    }

    @Override
    public double getPrice(){
        return this.decoratedPizza.getPrice();
    }
}

class PaneerPizza extends PizzaDecorator{

    public PaneerPizza(Pizza pizza) {
        super(pizza);
    }
     public String getDescription(){
        return this.decoratedPizza.getDescription() + " +  Paneer";
     }
     public double getPrice(){
        return this.decoratedPizza.getPrice() + 1.0;
     }
}
class MushroomPizza extends PizzaDecorator{

    public MushroomPizza(Pizza pizza) {
        super(pizza);
    }
    public String getDescription(){
        return this.decoratedPizza.getDescription() + " +  Mushroom";
    }
    public double getPrice(){
        return this.decoratedPizza.getPrice() + 1.0;
    }
}
public class DecoratorDesignPattern {


    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        Pizza paneerPizza = new PaneerPizza(pizza);
        System.out.println(paneerPizza.getDescription() + " $" +paneerPizza.getPrice());
        Pizza mushroomPaneerPizza = new MushroomPizza(paneerPizza);
        System.out.println(mushroomPaneerPizza.getDescription() + " $" +mushroomPaneerPizza.getPrice());
    }
}
