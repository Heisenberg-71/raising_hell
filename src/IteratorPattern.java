import java.util.Iterator;

interface MyCollection{
    Iterator<String> getIteartor();
}
class fruitCollection implements MyCollection{
    private String[] fruit={"mango","banana","apple"};
    @Override
    public Iterator<String> getIteartor(){
        return new fruitIterator();
    }
    private class fruitIterator implements Iterator<String>{
        private int index=0;
        @Override
        public boolean hasNext(){
            return index<fruit.length;
        }
        @Override
        public String next(){
            if(this.hasNext()){
                return fruit[index++];
            }
            return null;
        }

    }
}
public class IteratorPattern {
    public static void main(String[] args) {
       fruitCollection fruitCollection=new fruitCollection();
       Iterator<String> iterator=fruitCollection.getIteartor();
       while(iterator.hasNext()){
           System.out.println(iterator.next());
       }
    }
}
