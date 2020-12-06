import java.util.Random;

/**
 * 排序算法
 * 冒泡排序、插入排序、选择排序、归并排序、快速排序
 */
public class Sort {
    private void bubbleSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        boolean flag = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    private void insertionSort(int[] array) {
        if (array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }

    private void selectionSort(int[] array) {
        if (array.length  == 0) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            int pos = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[pos]) {
                    pos = j;
                }
            }

            if (pos != i) {
                int temp = array[pos];
                array[pos] = array[i];
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Sort mopao = new Sort();
        Random random = new Random();
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        long time = System.currentTimeMillis();
        mopao.selectionSort(array);
        for (int a : array) {
            System.out.print(a + ", ");
        }
        System.out.println(System.currentTimeMillis() - time);
    }
}
