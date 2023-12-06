package lab1;

public class VirusBuilder{

    private String name;
    private int group;

    public VirusBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public VirusBuilder setGroup(int group) {
        this.group = group;
        return this;
    }

    public Virus build(){

        Virus virus = new Virus(name, group);

        /* if(virus.doQualityCheck()){
            return virus;
        }else{
            System.out.println("MushroomOrLichen setting up is incomplete. Can't complete!");
        }
        return null; */

        return virus;

    }

}

