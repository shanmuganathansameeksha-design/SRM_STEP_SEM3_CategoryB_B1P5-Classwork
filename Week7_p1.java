public abstract class Toy {
    private static int counter = 1001;
    private final String toyId;
    protected String name;

    public Toy(String name) {
        this.name = name;
        this.toyId = "TOY-" + counter++;
    }

    public String getToyId() {
        return toyId;
    }

    public abstract String makeSound();
}

class ToyCar extends Toy {
    public ToyCar(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    public ToyRobot(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}