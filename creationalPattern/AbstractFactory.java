

interface Button {
    void click();
}

class WindowButton implements Button {

    @Override
    public void click() {
        System.out.println("window button clicked");
    }
}

class MacButton implements Button {

    @Override
    public void click() {
        System.out.println("macbook button clicked");
    }
}



 // checkbox //

interface Checkbox {
    void check();
}

class WindowCheckbox implements Checkbox {

    @Override
    public void check() {
        System.out.println("window checkbox is checked");
    }
}

class MacbookCheckbox implements Checkbox {

    @Override
    public void check() {
        System.out.println("macbook checkbox is checked");
    }
}

interface  GUIFactory {
    Button getButton();
    Checkbox getCheckbox();

}


class MacbookFactory implements GUIFactory {

    @Override
    public Button getButton() {
        return new MacButton();
    }

    @Override
    public Checkbox getCheckbox() {
        return new MacbookCheckbox();
    }
}

class WindowFactory implements  GUIFactory {

    @Override
    public Button getButton() {
        return new WindowButton();
    }

    @Override
    public Checkbox getCheckbox() {
        return new WindowCheckbox();
    }
}


public class AbstractFactory {
    public static void main(String[] args) {
        GUIFactory windowFactory = new WindowFactory();
        windowFactory.getButton().click();
        windowFactory.getCheckbox().check();

        GUIFactory macbookFactory = new MacbookFactory();
        macbookFactory.getButton().click();
        macbookFactory.getCheckbox().check();
    }
}
