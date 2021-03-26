
import java.util.Arrays;

/**
 * Sorting Algorithms 
 * Quick Sort,Radix Sort,Shell Sort,Counting Sort
 *
 * @author uUMUTt
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 15, 155, 3, 2, 44, 99, 12, 10, 75, 48, 27};
        int[] arr1 = {77, 12547, 122, 1, 102, 44, 88, 3, 14, 46, 32};
        int[] arr2 = {8, 24, 142, 79, 61, 1, 45, 13, 6, 46, 32};
        Sorting s = new Sorting();

        System.out.println(Arrays.toString(arr));
        s.radixSort(arr);
        System.out.println("Radix sort: " + Arrays.toString(arr));

        System.out.println("========================================");

        System.out.println(Arrays.toString(arr1));
        s.shellSort(arr1);
        System.out.println("Shell Sort: " + Arrays.toString(arr1));

        System.out.println("========================================");

        System.out.println(Arrays.toString(arr2));
        s.quickSort(arr2, 0, (arr2.length - 1));//quickSort(array,first index,last index)
        System.out.println("Quick Sort: " + Arrays.toString(arr2));
        
        System.out.println("Denememe");
        System.out.println("Denememe");
    }
}
