package structuralPattern;



interface Coffee {
    String getDescription();
    int getCost();
}

class NormalCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "normal Coffee ";
    }

    @Override
    public int getCost() {
        return 120;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();  // Delegating behavior
    }

    @Override
    public int getCost() {
        return coffee.getCost();  // Delegating behavior
    }
}

class Elaichi extends CoffeeDecorator {

    public Elaichi(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + " Elaichi ";
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() +  50;
    }
}

class Adarak extends CoffeeDecorator {

    public Adarak(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + " Adarak ";
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 25;
    }
}

public class Decorator {
    public static void main(String[] args) {
        NormalCoffee normalCoffee = new NormalCoffee();
        Coffee elaichiCoffee = new Elaichi(normalCoffee);
        Coffee coffeeWithAdarak = new Adarak(elaichiCoffee);
        System.out.println(elaichiCoffee.getDescription() + elaichiCoffee.getCost());
    }
}