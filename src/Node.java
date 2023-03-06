public class Node {
    public int value;
    public Node prev;
    public Node next;


    public Node(int value, Node prev, Node next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
    public Node(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
    public Node() {
        this.value = 0;
        this.prev = null;
        this.next = null;
    }
}
