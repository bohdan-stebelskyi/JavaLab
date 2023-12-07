package lab4;

import lab3.Person;
import lab3.Vehicle;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Person> person1 = new TreeSet<>();
        Person.PersonBuilder obj1 = new Person.PersonBuilder();
        Person.PersonBuilder obj2 = new Person.PersonBuilder();
        Person.PersonBuilder obj3 = new Person.PersonBuilder();

        obj1.setFirstName("John");
        obj1.setSecondName("Doe");
        obj1.setAge(27);
        obj1.setVehicle(new Vehicle("Minivan", "White", 5748459, "Mitsubishi"));

        obj2.setFirstName("Chriss");
        obj2.setSecondName("Cornell");
        obj2.setAge(46);
        obj2.setVehicle(new Vehicle("Automobile", "Red", 9567456, "Ferrari"));

        obj3.setFirstName("Layne");
        obj3.setSecondName("Staley");
        obj3.setAge(31);
        obj3.setVehicle(new Vehicle("Automobile", "Red", 546323, "Corvet"));

        person1.add(obj1.build());
        person1.add(obj2.build());
        person1.add(obj3.build());
        for (Person p : person1) {
            System.out.println(p);
        }
        System.out.println("\n");
    }
}