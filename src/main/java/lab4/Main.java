package lab4;

public class Main {
    public static void main(String[] args) {
        Person.PersonBuilder obj1 = new Person.PersonBuilder();
        Person.PersonBuilder obj2 = new Person.PersonBuilder();
        Vehicle.VehicleBuilder obj3 = new Vehicle.VehicleBuilder();

        Vehicle v = new Vehicle.VehicleBuilder()
                .setType("Automobile")
                .setColor("Red")
                .setNumber(123456)
                .setModel("Toyota").build();

        Person p = new Person.PersonBuilder()
                .setFirstName("John")
                .setSecondName("Doe")
                .setAge(25)
                .setVehicle(v).build();

        obj2.setFirstName("Victor");
        obj2.setSecondName("Pavlik");
        obj2.setAge(49);
        obj2.setVehicle(new Vehicle("Minivan", "Black", 784955, "Mercedes")); //null test

        System.out.println(obj1.build());
        System.out.println(obj2.build());
        System.out.println(obj3.build());
    }
}