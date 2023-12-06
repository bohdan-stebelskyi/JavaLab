package lab3;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceNoStream implements PersonServiceInterface {
    private List<Person> myList;

    public PersonServiceNoStream(List<Person> myList) {
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

    public List<Person> getPersonsByFirstName(String firstName) {
        List<Person> result = new ArrayList<>();
        for (Person person : myList) {
            if (firstName.equals(person.getFirstName())) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getPersonsBySecondName(String secondName) {
        List<Person> result = new ArrayList<>();
        for (Person person : myList) {
            if (secondName.equals(person.getSecondName())) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getPersonsByAge(Integer age){
        List<Person> result = new ArrayList<>();
        for(Person person : myList){
            if(age.equals(person.getAge())){
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getPersonsByVehicleModel(String city) {
        List<Person> result = new ArrayList<>();
        for (Person person : myList) {
            if (city.equals(person.getVehicle().getModel())) {
                result.add(person);
            }
        }
        return result;
    }
}
