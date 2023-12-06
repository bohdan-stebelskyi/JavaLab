package lab1;

class Cellular extends WildLife{

    private final boolean hasCells = true;
    public Cellular(){
        super();
        System.out.println("Cellular default constructor");
    }

    public boolean getHasCells(){ return this.hasCells; }

}
