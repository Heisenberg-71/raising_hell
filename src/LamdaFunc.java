
interface functionalinterface {
    void add(int x,int z);
}

public class LamdaFunc {
    public static void main(String[] args) {
                 functionalinterface functionalInterface =(int x, int z)->{
                     System.out.println("added: "+(x+z));
                 };
                 functionalInterface.add(10,30);
    }
}
