package behaviouralDesignPattern.strategyDesignPattern;

interface PricingStrategy{
    public double calculatePrice(double regularPrice);
}
class RegularPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(double regularPrice){
        return regularPrice;
    }
}
class DiscountPriceStrategy implements PricingStrategy{
    private double discountPercent;
    public DiscountPriceStrategy(double discount){
        this.discountPercent = discount;
    }
    @Override
    public double calculatePrice(double regularPrice){
        return regularPrice * ( 1 - this.discountPercent/100);
    }
}
class PremiumPriceStrategy implements PricingStrategy{

    private double premiumPercent;
    public PremiumPriceStrategy(double premiumPercent){
        this.premiumPercent = premiumPercent;
    }

    @Override
    public double calculatePrice(double regularPrice){
        return regularPrice * ( 1 + premiumPercent/100);
    }
}

class EcommerceProduct{
    String name;
    PricingStrategy pricingStrategy;
    public EcommerceProduct(String name){
        this.name = name;
        this.pricingStrategy = new RegularPricingStrategy();
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }

    public double calculatePrice(double regularPrice){
        return pricingStrategy.calculatePrice(regularPrice);
    }
}
public class StrategyDesignPattern {
    public static void main(String[] args) {
        EcommerceProduct ecommerceProduct = new EcommerceProduct("Start");
        ecommerceProduct.setPricingStrategy(new DiscountPriceStrategy(20));
        System.out.println(ecommerceProduct.calculatePrice(100));
        ecommerceProduct.setPricingStrategy(new PremiumPriceStrategy(30));
        System.out.println(ecommerceProduct.calculatePrice(100));
    }


}
