package main;

public class test {
    
    public static void main (String[] args) {
        int[][] tileNum;
        int[][] tileNumSub = new int[3][3];
        tileNum = tileNumSub;
        System.out.println(tileNum.equals(tileNumSub));
    }
}
