import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyLruBaseArray<T> {

    public static final int CAPACITY_DEFAULT = 1 << 3;

    private T[] value;

    private Map<T, Integer> hold;

    private int capacity;

    private int length;

    public MyLruBaseArray() {
        this(CAPACITY_DEFAULT);
    }

    public MyLruBaseArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[this.capacity];
        hold = new HashMap<>();
    }

    public void addData(T data) {
        if (isContain(data)) {
            updateData(data);
        } else {
            if (isFull()) {
                removeEndData();
            }
            cacheData(data, length);
        }
    }

    private void updateData(T data) {
        int end = hold.get(data);
        rightShift(end);
        cacheData(data, 0);
    }

    private void removeEndData() {
        T data = value[--length];
        hold.remove(data);
    }

    private void cacheData(T data, int end) {
        rightShift(end);
        value[0] = data;
        hold.put(data, 0);
        length++;
    }

    private void rightShift(int end) {
        for (int i = end - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            hold.put(value[i], i + 1);
        }
    }

    public void deleteData(T data) {

    }

    public boolean isContain(T data) {
        return hold.containsKey(data);
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == capacity;
    }

//    private void addData(T data) {
//        if (this.length == this.capacity) {
//            deleteData(data);
//        } else {
//            for (int i = this.capacity - 1; i > 0; i--) {
//                if (array[i - 1] != null) {
//                    array[i] = array[i - 1];
//                }
//            }
//        }
//
//        insertToBegin(data);
//    }
//
//    private void insertToBegin(T data) {
//
//
//        array[0] = data;
//
//        length++;
//    }
//
//    private void deleteData(T data) {
//        boolean isFind = false;
//        for (int i = this.capacity - 1; i > 0; i--) {
//            if (!isFind && array[i].equals(data)) {
//                isFind = true;
//                array [i] = null;
//            }
//            if (isFind) {
//                array[i] = array[i - 1];
//            }
//        }
//
//        if (!isFind) {
//            array[this.length - 1] = null;
//        } else {
//            array[0] = null;
//        }
//
//        length--;
//    }

    private void printAll() {
        for (T t : value) {
            System.out.print(t + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLruBaseArray array = new MyLruBaseArray();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            array.addData(scanner.nextInt());
            array.printAll();
        }
    }
}
