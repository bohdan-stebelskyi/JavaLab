package lab1;

public class Main {
    public static void main(String[] args) {


        Animal animal = new AnimalBuilder().setGroup(6).build();
        System.out.println(animal.toString());

        Bacteria bacteria = new BacteriaBuilder().setName("Bactery1").setGroup(7).build();
        System.out.println(bacteria.toString());




        /*System.out.println("Person {"
                + " name = '" + "sdfgf" + '\''
                + ", group = '" + "kdfhj" + '\''
                + " }");*/
    }
}
