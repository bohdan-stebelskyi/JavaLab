package lab3;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonServiceStream implements PersonServiceInterface {
    public List<Person> myList;

    public PersonServiceStream(List<Person> myList) {
        this.myList = myList;
    }

    public List<Person> getMyList() {
        return myList;
    }

    public void setMyList(List<Person> myList) {
        this.myList = myList;
    }

    @Override
    public List<Person> getPersons() {
        return null;
    }

    @Override
    public void setPersons(List<Person> myList) {

    }

    public List<Person> getPersonsByFirstName(String firstName)
    {
        return getMyList().stream().filter(getFirstName(firstName)).collect(Collectors.toList());
    }
    public List<Person> getPersonsBySecondName(String secondName)
    {
        return getMyList().stream().filter(person -> secondName.equals(person.getSecondName())).collect(Collectors.toList());
    }
    public List<Person> getPersonsByAge(Integer age)
    {
        return getMyList().stream().filter(person -> age.equals(person.getAge())).collect(Collectors.toList());
    }
    public List<Person> getPersonsByVehicleModel(String model)
    {
        return getMyList().stream().filter(person -> model.equals(person.getVehicle().getModel())).collect(Collectors.toList());
    }

    private Predicate<Person> getFirstName (String firstName)
    {
        return person -> firstName.equals(person.getFirstName());
    }
}
