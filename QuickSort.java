import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class QuickSort extends SortingAlgorithmImpl {
    @Override
    public void sort(int[] a) {
        // choose three random numbers as candidates for pivot
        // then choose the median from these three numbers as the pivot
        preparePivot(a);
        //at this point
        //pivot is the first element in the array
//        System.out.println("pivot: " + a[0]);
        quickSort(a, 0, a.length);

    }

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = partition(a, low, high);
            quickSort(a, low, mid);
            quickSort(a, mid + 1, high);
        }

    }

    private int partition(int[] a, int low, int high) {
        int i = low + 1;
        int j = high - 1;
//        System.out.println(String.format("low:%d high:%d", low, high));
        int pivot = a[low];
        while (i <= j) {
            while (i <= j && a[i] <= pivot) {
                i++;
            }
            while (i <= j && pivot <= a[j]) {
                j--;
            }
            if (i < j) {
                swapValues(a, i, j);
            }
        }
        swapValues(a, low, j);
        return j;
    }

    private void preparePivot(int[] a) {
        int[] numbers = findThreeRandomNum(a);
        int[] numbersAtIndex = Arrays.copyOf(numbers, 3);
        convertToValues(numbers, a);
        HashMap<Integer, Integer> record = new HashMap<>();
        //        <value, index>
        for (int i = 0; i < numbers.length; i++) {
            record.put(numbers[i], numbersAtIndex[i]);
        }
        int pivot = findMedianInRandoms(numbers);
        swapValues(a, 0, record.get(pivot));
    }

    private void convertToValues(int[] nums, int[] a) {
        for (int j = 0; j < nums.length; j++) {
            nums[j] = a[nums[j]];
        }
    }

    private int findMedianInRandoms(int[] threeRandomNum) {
        new InsertionSort().sort(threeRandomNum);
        return threeRandomNum[1];
    }

    private int[] findThreeRandomNum(int[] a) {
        int[] nums = {0, 0, 0};
        Random random = new Random();
        int index;
        int i = 0;
        while (i < 3) {
            index = random.nextInt(a.length);
            boolean flag = true;
            for (int num : nums) {
                if (num == index) {
                    flag = false;
                }
            }
            if (flag) {
                nums[i] = index;
                i++;
            }
        }
        return nums;
    }
}
