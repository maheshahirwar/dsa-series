package core.dsa.implementation.linkedlist_stack_and_queue;

public class TestMyLinkedList {
	public static void main(String[] args) {

		MyLinkedList<String> list = new MyLinkedList<>();
		System.out.println("Initial size operations...\n");

		list.add("a");
		list.add("b");
		list.add(null);
		list.add("d");

		list.forEach(e -> System.out.print("[" + e + "]->"));
		System.out.println("null");

		System.out.println("search(\"b\"): " + list.search("b"));
		System.out.println("remove(1): " + list.remove(1));
		System.out.println("search(\"d\"): " + list.search("d"));

		list.insert(0, "x");
		list.insert(1, "z");

		list.forEach(e -> System.out.print("[" + e + "]->"));
		System.out.println("null\n");

		for (String ele : list) {
			System.out.print("{" + ele + "} ");
		}
	}
}
