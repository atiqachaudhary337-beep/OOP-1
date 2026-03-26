public class ElectricCar extends Car {
    private int batteryCapacity;
    private int chargingTime;

    public ElectricCar(String brand, String model, int speed,
                       String fuelType, int numberOfDoors,
                       int batteryCapacity, int chargingTime) {
        super(brand, model, speed, fuelType, numberOfDoors);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Charging Time: " + chargingTime + " hours");
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.println("Electric motor activated.");
    }

    public int calculateRange() {
        return batteryCapacity * 6;
    }

    public void chargeBattery() {
        System.out.println("Charging battery. Time required: " + chargingTime + " hours.");
    }

    public String toString() {
        return "Electric Car - Battery: " + batteryCapacity + " kWh, Charging Time: " + chargingTime + " hrs";
    }
}
