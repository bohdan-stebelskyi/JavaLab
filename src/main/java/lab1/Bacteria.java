package lab1;

import java.util.Objects;

class Bacteria extends Prokaryote{
    private String name;
    private int group;
    public Bacteria(){
        super();
        System.out.println("Bacteria default constructor");
    }

    public Bacteria(String name, int group){
        this();
        System.out.println("Bacteria (String, int) constructor");
        this.name = name;
        this.group = group;
    }


    public String getName(){ return this.name; }
    public int getGroup(){ return this.group; }

    public void setName(String name){ this.name = name; }
    public void setGroup(int group){ this.group = group; }

    // public boolean doQualityCheck(){ return (name != null && !name.trim().isEmpty() && (group != 0)); }

    @Override
    public String toString(){
        return "Bacteria {"
                + " name = '" + name + '\''
                + ", group=" + group
                + " }";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Bacteria that = (Bacteria) o;

        /*
        if(!Objects.equals(name, that.name)) return false;
        if(!Objects.equals(group, that.group)) return false;

        return true;
        */

        if(group != that.group) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode(){
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + group;
        return result;
        //return Objects.hash(name, group);
    }
}
