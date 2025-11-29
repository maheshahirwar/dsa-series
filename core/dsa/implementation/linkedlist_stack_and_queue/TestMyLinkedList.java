package core.dsa.implementation.linkedlist_stack_and_queue;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        System.out.println("Initial size operations...");
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("d");

        System.out.println("get(0): " + list.get(0));
        System.out.println("get(1): " + list.get(1));
        System.out.println("get(2): " + list.get(2));
        System.out.println("get(3): " + list.get(3));

        System.out.println("search(\"b\"): " + list.search("b"));
        System.out.println("search(null): " + list.search(null));
        System.out.println("search(\"z\"): " + list.search("z"));

        System.out.println("remove(1): " + list.remove(1));
        System.out.println("search(\"d\"): " + list.search("d"));
        System.out.println("remove(0): " + list.remove(0));
        System.out.println("remove(0): " + list.remove(0));

        try {
            list.remove(10);
            System.out.println("ERROR: expected exception for remove(10)");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Caught expected exception for remove(10): " + ex.getMessage());
        }

        System.out.println("All tests done");
    }
}
