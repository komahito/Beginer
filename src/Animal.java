public class Animal implements Registeration{
    private int id;
    private final String name;
    public Animal (String name) {
        this.name = name;
    }
    public int getID () {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public void registration () {
        AnimalIDtbl dataTbl = new AnimalIDtbl();
        this.id = dataTbl.add(this);
    }
}
