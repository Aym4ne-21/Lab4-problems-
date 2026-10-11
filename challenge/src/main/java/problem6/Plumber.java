package problem6;

public class Plumber extends Person {
    public Plumber(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("I am " + name + " the Plumber");
    }
}