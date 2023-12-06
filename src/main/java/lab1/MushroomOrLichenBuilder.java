package lab1;

public class MushroomOrLichenBuilder{

    private String name;
    private int group;

    public MushroomOrLichenBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MushroomOrLichenBuilder setGroup(int group) {
        this.group = group;
        return this;
    }

    public MushroomOrLichen build(){

        MushroomOrLichen mushroomOrLichen = new MushroomOrLichen(name, group);

        /* if(mushroomOrLichen.doQualityCheck()){
            return mushroomOrLichen;
        }else{
            System.out.println("MushroomOrLichen setting up is incomplete. Can't complete!");
        } */

        return mushroomOrLichen;

    }

}
