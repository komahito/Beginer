public interface IDtbl {
    /* use this format tbl
    static Hashmap<ArrayList<Integer>, ArrayList<Integer>> idTbl;
    */
    int add (Registeration o);
    void remove (String name);
    void remove (int id);
    int getId (String name);
    String getName (int id);
    Object getObjects (int id);
    Object getObjects (String name);
}