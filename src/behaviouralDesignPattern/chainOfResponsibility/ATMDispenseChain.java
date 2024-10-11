package behaviouralDesignPattern.chainOfResponsibility;

import java.util.Scanner;

public class ATMDispenseChain {
    private DispenseChain c1;

    public ATMDispenseChain(){
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();
        c1.setNext(c2);
        c2.setNext(c3);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenseChain = new ATMDispenseChain();
        while (true){
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if(amount % 10 == 0){
                atmDispenseChain.c1.dispense(new Currency(amount));
            }
            else{
                System.out.println("Enter the amount in multiple of 10");
            }
        }
    }
}
