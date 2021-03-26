
import java.util.Arrays;

/**
 *
 * @author uUMUTt
 */
public class Sorting {

    public void countingSortPrimary(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] count = new int[max + 1];
        int[] temp = new int[arr.length];
        int i;
        for (i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (i = 0; i < arr.length; i++) {
            temp[--count[arr[i]]] = arr[i];
        }
        for (i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    public void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int pos = 1; max / pos > 0; pos *= 10) {
            countingSortBetter(arr, pos);//or
        //  countingSortPrimary(arr);
        }
    }

    public void countingSortBetter(int[] arr, int pos) {

        int[] count = new int[10];
        int[] temp = new int[arr.length];
        int i;

        for (i = 0; i < arr.length; i++) {
            count[(arr[i] / pos) % 10]++;
        }
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (i = arr.length - 1; i >= 0; i--) {
            temp[--count[(arr[i] / pos) % 10]] = arr[i];
        }
        for (i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        int temp;
        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[high] = arr[i + 1];
        arr[i + 1] = pivot;

        return i + 1;
    }

    public void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public void shellSort(int[] arr) {
        int size = arr.length;
        int gap = (size - 1) / 2;

        for (int i = gap; i > 0; i /= 2) {
            gap = i;
            for (int a = i; a < size; a++) {
                int temp = arr[a];
                int j;
                for (j = a; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }

        }
    }
}
