package structuralPattern;



interface Color {
    void applyColor();
}

class RedColor implements Color {

    @Override
    public void applyColor() {
        System.out.println("apply red color");
    }
}

class BluColor implements Color {

    @Override
    public void applyColor() {
        System.out.println("apply blue color");
    }

}

abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}

class Circle extends Shape {
    private Color color;
    public Circle(Color color) {
        super(color);
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("draw Circle");
        this.color.applyColor();
    }
}

class Square extends Shape {
    private Color color;
    public Square(Color color) {
        super(color);
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("draw Square");
        this.color.applyColor();
    }
}

public class Bridge {
    public static void main(String[] args) {
        // create colors
        Color redColor = new RedColor();
        Color blueColor = new BluColor();

        // create circle with red color
        Shape circle = new Circle(redColor);
        circle.draw();

        // create square with red color
        Shape square = new Square(blueColor);
        square.draw();
    }
}