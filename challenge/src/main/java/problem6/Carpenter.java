package problem6;

public class Carpenter extends Person {
    public Carpenter(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("I am " + name + " the Carpenter");
    }
}