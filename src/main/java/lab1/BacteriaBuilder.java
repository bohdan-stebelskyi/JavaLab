package lab1;

public class BacteriaBuilder{

    private String name;
    private int group;

    public BacteriaBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public BacteriaBuilder setGroup(int group) {
        this.group = group;
        return this;
    }

    public Bacteria build(){

        Bacteria bacteria = new Bacteria(name, group);

        /* if(bacteria.doQualityCheck()){
            return bacteria;
        }else{
            System.out.println("MushroomOrLichen setting up is incomplete. Can't complete!");
        }
        return null; */

        return bacteria;

    }

}


