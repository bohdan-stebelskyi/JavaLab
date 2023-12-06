package lab1;

public class AnimalBuilder{
    Animal animal = new Animal();
    private String name;
    private int group;

    public AnimalBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AnimalBuilder setGroup(int group) {
        this.group = group;
        return this;
    }

    public Animal build(){

        Animal animal = new Animal(name, group);

        /* if(animal.doQualityCheck()){
            return animal;
        }else{
            System.out.println("Animal setting up is incomplete. Can't complete!");
        }
        return null; */

        return animal;

    }

}
