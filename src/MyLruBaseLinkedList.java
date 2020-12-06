import java.util.Scanner;

public class MyLruBaseLinkedList<T> {

    public static final int CAPACITY_DEFAULT = 10;

    private SNode headNode;

    private int length;

    private int capacity;

    public MyLruBaseLinkedList() {
        headNode = new SNode();
        capacity = CAPACITY_DEFAULT;
    }

    public MyLruBaseLinkedList(int capacity) {
        headNode = new SNode();
        capacity = CAPACITY_DEFAULT;
    }

    public void addData(T data) {
        SNode node = findPreNode(data);

        if (null != node) {
            deletePreNode(node);
        } else {
            if (length == capacity) {
                deleteEndNode();
            }
        }
        insertNodeAtBegin(data);
    }

    private void insertNodeAtBegin(T data) {
        SNode nextNode = headNode.getNext();
        headNode.setNext(new SNode(data, nextNode));
        length++;
    }

    private void deletePreNode(SNode preNode) {
        SNode tempNode = preNode.getNext();
        preNode.setNext(tempNode.getNext());
        tempNode = null;
        length--;
    }

    private void deleteEndNode() {
        SNode nextNode = headNode;

        if (null == nextNode.getNext()) {
            return;
        }

        while (nextNode.getNext().getNext() != null) {
            nextNode = nextNode.getNext();
        }

        SNode endNode = nextNode.getNext();
        nextNode.setNext(null);
        endNode = null;
        length--;
    }

    private SNode findPreNode(T data) {
        SNode preNode = headNode;
        while (null != preNode.getNext()) {
            if (preNode.getNext().getElement() == data) {
                return preNode;
            }
            preNode = preNode.next;
        }

        return null;
    }

    private void printAll() {
        SNode nextNode = headNode.getNext();
        while (null != nextNode) {
            System.out.print(nextNode.getElement() + ",");
            nextNode = nextNode.getNext();
        }
        System.out.println();
    }

    static class SNode<T> {
        private T element;
        private SNode next;

        public SNode() {

        }

        public SNode(T data) {
            this.element = data;
        }

        public SNode(T data, SNode next) {
            this.element = data;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
    public static void main(String[] args) {
        MyLruBaseLinkedList list = new MyLruBaseLinkedList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            list.addData(scanner.nextInt());
            list.printAll();
        }
    }
}
