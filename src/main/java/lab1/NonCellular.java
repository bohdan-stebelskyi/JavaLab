package lab1;

class NonCellular extends WildLife{

    private final boolean hasCells = false;

    public NonCellular(){
        super();
        System.out.println("NonCellular default constructor");
    }

    public boolean getHasCells(){ return this.hasCells; }

}
