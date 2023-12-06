package lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Set;

public class Person implements Comparable<Person> {
    private String firstName;
    private String secondName;
    private int age;
    private Vehicle vehicle;

    private Person(String firstName, String secondName, int age, Vehicle vehicle) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.vehicle = vehicle;
    }

    private Person(Person.PersonBuilder pb) {
        this.firstName = pb.firstName;
        this.secondName = pb.secondName;
        this.age = pb.age;
        this.vehicle = pb.vehicle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return  Objects.equals(firstName, person.firstName) &&
                Objects.equals(secondName, person.secondName) &&
                Objects.equals(age, person.age) &&
                Objects.equals(vehicle, person.vehicle);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age, vehicle);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", vehicle=" + vehicle +
                '}';
    }

    @Override
    public int compareTo(Person other) {
        return this.age - other.age;
    }

    public static class PersonBuilder {
        @NotEmpty
        public String firstName;
        @NotEmpty
        public String secondName;
        @NotNull
        public int age;
        @NotNull
        public Vehicle vehicle;

        public Person.PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Person.PersonBuilder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Person.PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person.PersonBuilder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Person build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Person.PersonBuilder>> constraintViolations = validator.validate(this);
            StringBuilder exceptions = new StringBuilder("\n");
            for (ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                exceptions.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("\n");
            }
            if (constraintViolations.size() > 0) throw new IllegalArgumentException(String.valueOf(exceptions));
            return new Person(this);
        }
    }
}