package behaviouralDesignPattern;

import java.util.Iterator;

class Car implements Iterable<String> {
    String[] cars;
    int index;
    public Car(){
        cars = new String[10];
        index = 0;
    }
    public void addCar(String car){
        if(index == cars.length){
            String[] cars1 = new String[(int)(cars.length * 1.5)];
            for(int i = 0; i<cars.length;i++)cars1[i] = cars[i];
            cars = cars1;
        }
        cars[index++] = car;
    }
    public Iterator<String> iterator(){

        Iterator<String> iterator = new Iterator<String>() {
            int currIndex = 0;
            @Override
            public boolean hasNext() {
                return currIndex < cars.length && cars[currIndex] != null;
            }

            @Override
            public String next() {
                if(currIndex < cars.length){
                    return cars[currIndex++];
                }
                throw new IndexOutOfBoundsException("End of iterator");
            }
        };
        return iterator;
    }

}
public class IteratorPattern {
    public static void main(String[] args) {
        Car car = new Car();
        Iterator<String> carIterator = car.iterator();
        for(char a = 'a'; a < 'z'; a++){
            car.addCar("" + a);
        }
        while (carIterator.hasNext()){
            System.out.println(carIterator.next());
        }
    }
}
