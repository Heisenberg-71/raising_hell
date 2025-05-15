public class BoxingUnboxing {
    public static void main(String[] args) {
        System.out.println("Auto-Boxing:");
        int num=10;
        Integer i=Integer.valueOf(num);
        System.out.println("wrapper class:"+i);
        System.out.println("Unboxing :");
        Integer n=20;
        int a=n.intValue();
        System.out.println("primitive data types:"+a);

    }
}
