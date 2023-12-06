package lab1;

class Eukaryote extends Cellular{

    private final boolean hasCore = true;

    public Eukaryote(){
        super();
        System.out.println("Eukaryote default constructor");
    }

    public boolean getHasCore(){ return this.hasCore; }

}