public class Vehicle {
    private String brand;
    private String model;
    private int speed;

    public Vehicle(String brand, String model, int speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public void displayInfo() {
        System.out.println("Vehicle Information:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Speed: " + speed + " km/h");
    }

    public int calculateValue() {
        return speed * 100;
    }

    public void startEngine() {
        System.out.println("Vehicle engine started.");
    }

    public String toString() {
        return brand + " " + model + " (" + speed + " km/h)";
    }
}
