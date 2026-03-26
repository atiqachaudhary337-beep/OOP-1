public class Test {
    public static void main(String[] args) {

        System.out.println("OOP LAB TASK");
        System.out.println("Submitted by: ATIQA CHAUDHARY\n");

        Vehicle v = new Vehicle("Honda", "Civic", 180);
        Car c = new Car("Toyota", "Corolla", 160, "Petrol", 4);
        ElectricCar e = new ElectricCar("Tesla", "Model 3", 200, "Electric", 4, 75, 2);

        System.out.println("--- Vehicle ---");
        v.displayInfo();
        v.startEngine();
        System.out.println("Value: " + v.calculateValue());
        System.out.println(v.toString());

        System.out.println("\n--- Car ---");
        c.displayInfo();
        c.startEngine();
        System.out.println("Range: " + c.calculateRange());
        System.out.println(c.toString());

        System.out.println("\n--- Electric Car ---");
        e.displayInfo();
        e.startEngine();
        System.out.println("Range: " + e.calculateRange());
        e.chargeBattery();
        System.out.println(e.toString());
    }
}