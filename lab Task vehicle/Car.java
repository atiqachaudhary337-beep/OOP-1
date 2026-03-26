public class Car extends Vehicle {
    private String fuelType;
    private int numberOfDoors;

    public Car(String brand, String model, int speed, String fuelType, int numberOfDoors) {
        super(brand, model, speed);
        this.fuelType = fuelType;
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Number of Doors: " + numberOfDoors);
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Car engine running on " + fuelType + ".");
    }

    public int calculateRange() {
        return numberOfDoors * 50;
    }

    public String toString() {
        return "Car - Fuel: " + fuelType + ", Doors: " + numberOfDoors;
    }
}
