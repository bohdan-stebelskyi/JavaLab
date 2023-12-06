package lab1;

public class PlantBuilder{

    private String name;
    private int group;

    public PlantBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlantBuilder setGroup(int group) {
        this.group = group;
        return this;
    }

    public Plant build(){

        Plant plant = new Plant(name, group);

        /* if(plant.doQualityCheck()){
            return plant;
        }else{
            System.out.println("Plant setting up is incomplete. Can't complete!");
        }
        return null; */

        return plant;

    }

}