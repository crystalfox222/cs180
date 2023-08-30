public class test {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addNode(1);
        list.addNode(1);
        list.addNode(2);
        list.printList();
        list.deleteNode(2);
        list.printList();
    }
}
