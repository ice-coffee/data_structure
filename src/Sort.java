import java.util.Random;

/**
 * 排序算法
 * 冒泡排序、插入排序、选择排序、归并排序、快速排序
 */
public class Sort {
    /**
     * 冒泡排序
     */
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

    /**
     * 插入排序
     */
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

    /**
     * 选择排序
     */
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

    private void mergeSort(int[] array) {
        mergeSortc(array, 0, array.length - 1);
    }

    private void mergeSortc(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;
        mergeSortc(array, p, q);
        mergeSortc(array, q + 1, r);

        merge(array, p, q, r);
    }

    private void merge(int[] array, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        int[] mergeArray = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                mergeArray[k++] = array[i++];
            } else {
                mergeArray[k++] = array[j++];
            }
        }

        int start = i, end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        for (int b = start; b <= end; b++) {
            mergeArray[k++] = array[b];
        }

        for (int a = 0; a < mergeArray.length; a++) {
            array[p + a] = mergeArray[a];
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
        mopao.mergeSort(array);
        for (int a : array) {
            System.out.print(a + ", ");
        }
        System.out.println(System.currentTimeMillis() - time);
    }
}
