package lab3;

import java.util.List;

public interface PersonServiceInterface {
    List<Person> getPersons();
    void setPersons(List<Person> myList);

    List<Person> getPersonsByFirstName(String firstName);
    List<Person> getPersonsBySecondName(String secondName);
    List<Person> getPersonsByAge(Integer age);
    List<Person> getPersonsByVehicleModel(String model);
}