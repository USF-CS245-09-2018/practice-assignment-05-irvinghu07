import java.util.Arrays;

public abstract class SortingAlgorithmImpl implements SortingAlgorithm {

    public void swapValues(int[] arr, int firstIndex, int secondIndex) throws ArrayIndexOutOfBoundsException {
        if (firstIndex != secondIndex) {
            int temp = arr[firstIndex];
            arr[firstIndex] = arr[secondIndex];
            arr[secondIndex] = temp;

        }
    }
}
