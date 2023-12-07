package lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;
import java.util.Set;

public class Vehicle {
    public String type;
    public String color;
    public int number;
    public String model;

    public Vehicle(String type, String color, int number, String model) {
        this.type = type;
        this.color = color;
        this.number = number;
        this.model = model;
    }

    public Vehicle(Vehicle.VehicleBuilder vb) {
        this.type = vb.type;
        this.color = vb.color;
        this.number = vb.number;
        this.model = vb.model;
    }

    public Vehicle() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return  Objects.equals(type, vehicle.type) &&
                Objects.equals(color, vehicle.color) &&
                Objects.equals(number, vehicle.number) &&
                Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, color, number, model);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", number=" + number +
                ", model='" + model + '\'' +
                '}';
    }

    public static class VehicleBuilder {
        @NotEmpty
        public String type;
        @NotEmpty
        public String color;
        @NotNull
        @Positive(message = "Number must be a positive number")
        public int number;
        @NotEmpty
        public String model;

        public Vehicle.VehicleBuilder setType(String type) {
            this.type = type;
            return this;
        }
        public Vehicle.VehicleBuilder setColor(String color) {
            this.color = color;
            return this;
        }
        public Vehicle.VehicleBuilder setNumber(int number) {
            this.number = number;
            return this;
        }
        public Vehicle.VehicleBuilder setModel(String model) {
            this.model = model;
            return this;
        }


        public Vehicle build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Vehicle.VehicleBuilder>> constraintViolations = validator.validate(this);
            StringBuilder exceptions = new StringBuilder("\n");
            for (ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                exceptions.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("\n");
            }
            if (constraintViolations.size() > 0) throw new IllegalArgumentException(String.valueOf(exceptions));
            return new Vehicle(this);
        }
    }
}