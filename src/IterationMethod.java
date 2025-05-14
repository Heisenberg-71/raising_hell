import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class IterationMethod {
    public static void main(String[] args) {
        ArrayList<String> fruit =new ArrayList<>();
        fruit.add("mango");
        fruit.add("apple");
        fruit.add("banana");

        System.out.println("Iterating using Iterator:");
        Iterator<String> iterator=fruit.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+" ");
        }

        System.out.println("\nIterating using Enumeration:");
        Vector<String> fruitVector=new Vector<>(fruit);
        Enumeration<String> enumeration=fruitVector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement()+" ");
        }

        System.out.println("\nIterating using advanced for loop:");
        for (String word:fruit){
            System.out.println(word+" ");
        }
    }
}
