import java.util.*;

// Comparable example - natural ordering defined within class
class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name); // Sort by name
    }


}

public class comparator_comparable {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25));
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 20));

        // Using Comparable (natural ordering - by name)
        Collections.sort(people);
        System.out.println("Sorted by name: " + people);

        // Using Comparator (external ordering - by age)
        Comparator<Person> com=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                 if (o1.age > o2.age){
                     return 1;
                 }
                 else{
                     return -1;
                 }
            }
        };
        Collections.sort(people, com);
        System.out.println("Sorted by age: " + people);


    }
}