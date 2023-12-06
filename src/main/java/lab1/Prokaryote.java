package lab1;

class Prokaryote extends Cellular{

    private final boolean hasCore = false;
    public Prokaryote(){
        super();
        System.out.println("Prokaryote default constructor");
    }

    public boolean getHasCore(){ return this.hasCore; }

}