package lab3;

import java.util.*;


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
        obj3.setVehicle(new Vehicle("Automobile", "Red", 126775, "Corvet"));

        person1.add(obj1.build());
        person1.add(obj2.build());
        person1.add(obj3.build());
        for (Person p : person1) {
            System.out.println(p);
        }
        System.out.println("\n");


        List<Person> person2 = new ArrayList<>();
        Person.PersonBuilder obj4 = new Person.PersonBuilder();
        Person.PersonBuilder obj5 = new Person.PersonBuilder();
        Person.PersonBuilder obj6 = new Person.PersonBuilder();

        obj4.setFirstName("Will");
        obj4.setSecondName("Jayne");
        obj4.setAge(20);
        obj4.setVehicle(new Vehicle("Automobile", "Blue", 626772, "Dodge"));

        obj5.setFirstName("Stan");
        obj5.setSecondName("Cross");
        obj5.setAge(21);
        obj5.setVehicle(new Vehicle("Automobile", "Black", 978543, "Lamborghini"));

        obj6.setFirstName("Rick");
        obj6.setSecondName("Ross");
        obj6.setAge(39);
        obj6.setVehicle(new Vehicle("Automobile", "Green", 945767, "Toyota"));

        person2.add(obj4.build());
        person2.add(obj5.build());
        person2.add(obj6.build());
        Comparator surnameComparator = new PersonSurnameComparator();
        Collections.sort(person2, surnameComparator);
        for (Person p : person2) {
            System.out.println(p);
        }
        System.out.println("\n");

        List<Person> person3 = new ArrayList<>();
        Person.PersonBuilder obj7 = new Person.PersonBuilder();
        Person.PersonBuilder obj8 = new Person.PersonBuilder();
        Person.PersonBuilder obj9 = new Person.PersonBuilder();

        obj7.setFirstName("Piter");
        obj7.setSecondName("Parker");
        obj7.setAge(19);
        obj7.setVehicle(new Vehicle("Truck", "Yellow", 126772, "Hammer"));

        obj8.setFirstName("Yan");
        obj8.setSecondName("Cornell");
        obj8.setAge(37);
        obj8.setVehicle(new Vehicle("Automobile", "Grey", 555543, "Tesla"));

        obj9.setFirstName("Chriss");
        obj9.setSecondName("Honk");
        obj9.setAge(20);
        obj9.setVehicle(new Vehicle("Automobile", "Green", 945767, "Kia"));

        person3.add(obj7.build());
        person3.add(obj8.build());
        person3.add(obj9.build());
        person3.stream().sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);

        System.out.println("\n");

        List<Person> person4 = new ArrayList<>();
        Person.PersonBuilder obj10 = new Person.PersonBuilder();
        Person.PersonBuilder obj11 = new Person.PersonBuilder();
        Person.PersonBuilder obj12 = new Person.PersonBuilder();

        obj10.setFirstName("Phill");
        obj10.setSecondName("Leotardo");
        obj10.setAge(51);
        obj10.setVehicle(new Vehicle("Truck", "Yellow", 126772, "Hammer"));

        obj11.setFirstName("Tony");
        obj11.setSecondName("Soprano");
        obj11.setAge(46);
        obj11.setVehicle(new Vehicle("Automobile", "Grey", 555543, "Tesla"));

        obj12.setFirstName("Christopher");
        obj12.setSecondName("Moltisanti");
        obj12.setAge(26);
        obj12.setVehicle(new Vehicle("Automobile", "Green", 945767, "Kia"));

        person4.add(obj10.build());
        person4.add(obj11.build());
        person4.add(obj12.build());
        Comparator<Person> sortByAge = Comparator.comparing(Person::getAge);
        Comparator<Person> sortByFirstName = Comparator.comparing(Person::getFirstName);
        Comparator<Person> sortByLastName = Comparator.comparing(Person::getSecondName);
        List<Comparator<Person>> comparators = new ArrayList<>();
        comparators.add(sortByAge);
        comparators.add(sortByFirstName);
        comparators.add(sortByLastName);
        person4.sort(new ChainComparator(comparators));
        for (Person p : person4) {
            System.out.println(p);
        }

        System.out.println("\ntest");
        List<Person> test = new ArrayList<>();
        test.addAll(person1);
        test.addAll(person2);
        test.addAll(person3);
        test.addAll(person4);
        PersonServiceStream ps = new PersonServiceStream(test);
        System.out.println("Full list");
        for (Person p : test) {
            System.out.println(p);
        }

        System.out.println("\ngetPersonsByVehicleModel:");
        for (Person p : ps.getPersonsByVehicleModel("Toyota")) {
            System.out.println(p);
        }

        System.out.println("\ngetPersonsByFirstName");
        for (Person p : ps.getPersonsByFirstName("Chriss")) {
            System.out.println(p);
        }

        System.out.println("\ngetPersonsBySecondName");
        for (Person p : ps.getPersonsBySecondName("Cornell")) {
            System.out.println(p);
        }

        System.out.println("\ngetPersonsByAge");
        for (Person p : ps.getPersonsByAge(20)) {
            System.out.println(p);
        }
    }
}
