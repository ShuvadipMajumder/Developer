public class CollectionFrameworkExamples {
    public static void main(String[] args) {
        // Example of using a List
        // A List allows duplicate elements and maintains insertion order
        java.util.List<String> list = new java.util.ArrayList<>();
        list.add("Apple");
        list.add("Cherry");
        list.add("Banana");
        list.add("Apple"); // Duplicate, will be added

        System.out.println("List: " + list);

        // Example of using a Set
        // A Set does not allow duplicate elements
        java.util.Set<String> set = new java.util.HashSet<>(list);
        set.add("Date");
        set.add("Apple"); // Duplicate, won't be added
        //set.forEach(System.out::println);

        System.out.println("Set: " + set);

        // Example of using a Map
        // A Map stores key-value pairs, where keys are unique
        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("One", 11); // Duplicate key, will update the value
       // map.forEach((key, value) -> System.out.println( key +": "+value));
        System.out.println("Map: " + map);

        // Example of using a Queue
        // A Queue is a first-in-first-out (FIFO) data structure
        java.util.Queue<String> queue = new java.util.LinkedList<>();
        queue.add("First"); 
        queue.add("Second");
        queue.add("Third");
        System.out.println("Queue: " + queue);

        // Example of using a Stack
        // A Stack is a last-in-first-out (LIFO) data structure
        java.util.Stack<String> stack = new java.util.Stack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        System.out.println("Stack: " + stack);

        // Example of using a Deque
        // A Deque (Double-Ended Queue) allows insertion and removal of elements from both ends
        java.util.Deque<String> deque = new java.util.ArrayDeque<>();
        deque.addFirst("First");
        deque.addLast("Second");
        deque.addLast("Third");
        System.out.println("Deque: " + deque);

        // Example of using a PriorityQueue
        // A PriorityQueue orders elements based on their natural ordering or a custom comparator
        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);
        System.out.println("PriorityQueue: " + priorityQueue);

        // Example of using a SortedSet
        // A SortedSet maintains elements in a sorted order
        java.util.SortedSet<String> sortedSet = new java.util.TreeSet<>(set);
        sortedSet.add("Elderberry");
        //sortedSet.forEach(System.out::println);
        System.out.println("SortedSet: " + sortedSet);

        // Example of using a SortedMap
        // A SortedMap maintains key-value pairs in a sorted order based on keys
        java.util.SortedMap<String, Integer> sortedMap = new java.util.TreeMap<>(map);
        sortedMap.put("Zero", 0);
        //sortedMap.forEach((key,value) -> System.out.println(key+": "+value));
        System.out.println("SortedMap: " + sortedMap);  

        // Example of using a LinkedHashSet
        // A LinkedHashSet maintains insertion order while preventing duplicates
        java.util.LinkedHashSet<String> linkedHashSet = new java.util.LinkedHashSet<>(list);
        linkedHashSet.add("Fig");   
        linkedHashSet.add("Apple"); // Duplicate, won't be added
        System.out.println("LinkedHashSet: " + linkedHashSet);   

        // Example of using a LinkedHashMap
        // A LinkedHashMap maintains insertion order while allowing key-value pairs
        java.util.LinkedHashMap<String, Integer> linkedHashMap = new java.util.LinkedHashMap<>(map);
        linkedHashMap.put("Four", 4);
        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Example of using a Vector
        // A Vector is similar to an ArrayList but is synchronized
        java.util.Vector<String> vector = new java.util.Vector<>(list);
        vector.add("Grape");
        System.out.println("Vector: " + vector);

        // Example of using a Stack with generics
        // A Stack is a last-in-first-out (LIFO) data structure
        java.util.Stack<Integer> intStack = new java.util.Stack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        System.out.println("Integer Stack: " + intStack);

        // Example of using a CopyOnWriteArrayList
        // A CopyOnWriteArrayList is a thread-safe variant of ArrayList
        java.util.concurrent.CopyOnWriteArrayList<String> cowList = new java.util.concurrent.CopyOnWriteArrayList<>(list);
        cowList.add("Honeydew");    
        System.out.println("CopyOnWriteArrayList: " + cowList);

        // Example of using a ConcurrentHashMap
        // A ConcurrentHashMap is a thread-safe variant of HashMap
        java.util.concurrent.ConcurrentHashMap<String, Integer> concurrentMap = new java.util.concurrent.ConcurrentHashMap<>(map);
        concurrentMap.put("Five", 5);
        System.out.println("ConcurrentHashMap: " + concurrentMap);

        // // Example of using a EnumSet
        // // An EnumSet is a specialized Set for use with enum types
        // java.util.EnumSet<Day> enumSet = java.util.EnumSet.of(Day.MONDAY, Day.WEDNESDAY);
        // System.out.println("EnumSet: " + enumSet);
        // // Example of using a EnumMap
        // // An EnumMap is a specialized Map for use with enum types
        // java.util.EnumMap<Day, String> enumMap = new java.util.EnumMap<>(Day.class);
        // enumMap.put(Day.MONDAY, "Start of the week");
        // enumMap.put(Day.WEDNESDAY, "Midweek");
        // System.out.println("EnumMap: " + enumMap);
        
    }

}
