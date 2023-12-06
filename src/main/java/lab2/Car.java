package lab2;

import java.io.Serializable;
import java.util.Objects;

class Car implements Serializable {
    public String color;

    public int number;

    public String model;

    public Car(){ }

    public Car(String color, String model, int number){
        this();
        this.color = color;
        this.model = model;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number == car.number && Objects.equals(color, car.color) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, number, model);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", number=" + number +
                ", model='" + model + '\'' +
                '}';
    }
}
