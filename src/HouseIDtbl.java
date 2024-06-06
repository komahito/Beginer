import java.util.HashMap;
import java.util.ArrayList;
class HouseIDtbl implements IDtbl {
    private static HashMap<Integer, ArrayList<Object>> idTbl = new HashMap(); // id-<name-o>
    private static HashMap<String, ArrayList<Object>> nameTbl = new HashMap(); // name-<id-o>
    public int add (Registeration o){
        Integer id = this.newID();
        ArrayList<Object> item_name = new ArrayList ();
        String name = o.getName();
        ArrayList<Object> item_id = new ArrayList ();
        item_name.add(name);
        item_name.add(o);
        item_id.add(id);
        item_id.add(o);

        this.idTbl.put(id, item_name);
        this.nameTbl.put(name, item_id);

        return id.intValue();
    }
    public void remove (String name){
        Integer id = Integer.valueOf(this.getId(name));
        nameTbl.remove(name);
        idTbl.remove(id);
    }
    public void remove (int id){
        String name = this.getName(id);
        idTbl.remove(id);
        nameTbl.remove(name);
    }
    public int getId (String name){
        ArrayList<Object> item_id = this.nameTbl.get(name);
        Integer id = (Integer) item_id.get(0);
        return id.intValue();
    }
    public String getName (int id){
        ArrayList<Object> item_name = this.idTbl.get(Integer.valueOf(id));
        String name = (String) item_name.get(0);
        return name;
    }
    public Object getObjects (int id){
        return idTbl.get(id).get(1);
    }
    public Object getObjects (String name){
        return nameTbl.get(name).get(1);
    }
    private Integer newID () {
        int i;
        for (i = 0; i < idTbl.size(); i++) {
            if (idTbl.containsKey(i)) continue;
            else {
                return Integer.valueOf(i);
            }
        }
        return Integer.valueOf(i);
    }
}