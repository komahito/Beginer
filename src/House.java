public class House implements Registeration{
    private int id;
    private int add;
    private String host;
    public House (String host) {
        this.host = host;
    }
    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.host;
    }
    public void registration(){
        HouseIDtbl idTbl = new HouseIDtbl();
        this.id = idTbl.add(this);
        this.add = id;
    }
}
