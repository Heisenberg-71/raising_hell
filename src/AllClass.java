import java.util.*;
import java.util.concurrent.*;

public class AllClass {
    public static void main(String[] args) {
        // 1. List Implementations
        System.out.println("=== List Implementations ===");

        // ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        System.out.println("ArrayList: " + arrayList);

        // LinkedList
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        System.out.println("LinkedList: " + linkedList);

        // Vector
        Vector<Double> vector = new Vector<>();
        vector.add(1.5);
        vector.add(2.5);
        System.out.println("Vector: " + vector);

        // Stack
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("Stack: " + stack + ", Pop: " + stack.pop());

        // 2. Set Implementations
        System.out.println("\n=== Set Implementations ===");

        // HashSet
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Red");
        hashSet.add("Green");
        hashSet.add("Red"); // Duplicate won't be added
        System.out.println("HashSet: " + hashSet);

        // LinkedHashSet
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(30);
        linkedHashSet.add(10);
        linkedHashSet.add(20);
        System.out.println("LinkedHashSet (maintains insertion order): " + linkedHashSet);

        // TreeSet
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Zebra");
        treeSet.add("Apple");
        treeSet.add("Monkey");
        System.out.println("TreeSet (sorted): " + treeSet);

        // 3. Queue Implementations
        System.out.println("\n=== Queue Implementations ===");

        // PriorityQueue
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("Orange");
        priorityQueue.offer("Apple");
        priorityQueue.offer("Banana");
        System.out.print("PriorityQueue: ");
        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + " ");
        }
        System.out.println();

        // ArrayDeque
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offerFirst(10);
        arrayDeque.offerLast(20);
        System.out.println("ArrayDeque: " + arrayDeque);

        // 4. Map Implementations
        System.out.println("\n=== Map Implementations ===");

        // HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        System.out.println("HashMap: " + hashMap);

        // LinkedHashMap
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("First", "1st");
        linkedHashMap.put("Third", "3rd");
        linkedHashMap.put("Second", "2nd");
        System.out.println("LinkedHashMap (maintains insertion order): " + linkedHashMap);

        // TreeMap
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 26);
        treeMap.put("Apple", 1);
        treeMap.put("Monkey", 13);
        System.out.println("TreeMap (sorted by keys): " + treeMap);

        // Hashtable
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(3, "Three");
        hashtable.put(1, "One");
        System.out.println("Hashtable: " + hashtable);

        // 5. Special Implementations
        System.out.println("\n=== Special Implementations ===");

        // EnumSet
        enum Days { MONDAY, TUESDAY, WEDNESDAY }
        Set<Days> enumSet = EnumSet.allOf(Days.class);
        System.out.println("EnumSet: " + enumSet);

        // EnumMap
        Map<Days, String> enumMap = new EnumMap<>(Days.class);
        enumMap.put(Days.MONDAY, "First day");
        System.out.println("EnumMap: " + enumMap);

        // Collections utility methods
        List<String> singletonList = Collections.singletonList("Single");
        Set<String> emptySet = Collections.emptySet();
        System.out.println("Singleton List: " + singletonList);
        System.out.println("Empty Set: " + emptySet);

        // Arrays.asList
        List<String> fixedList = Arrays.asList("Fixed", "Size");
        System.out.println("Fixed-size List from array: " + fixedList);

        // 6. Concurrent Collections
        System.out.println("\n=== Concurrent Collections ===");

        // ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("A", 1);
        concurrentHashMap.put("B", 2);
        System.out.println("ConcurrentHashMap: " + concurrentHashMap);

        // CopyOnWriteArrayList
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("Safe");
        copyOnWriteArrayList.add("Thread");
        System.out.println("CopyOnWriteArrayList: " + copyOnWriteArrayList);

        // ArrayBlockingQueue
        BlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer(1);
        arrayBlockingQueue.offer(2);
        System.out.println("ArrayBlockingQueue: " + arrayBlockingQueue);

        // ConcurrentLinkedQueue
        Queue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        concurrentLinkedQueue.offer("Fast");
        concurrentLinkedQueue.offer("Non-blocking");
        System.out.println("ConcurrentLinkedQueue: " + concurrentLinkedQueue);
    }
}