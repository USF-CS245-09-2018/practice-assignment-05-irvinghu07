public class InsertionSort extends SortingAlgorithmImpl {

    @Override
    public void sort(int[] a) {
        int elementToBeCompare;
        int replaceElementIndex;
        for (int i = 1; i < a.length; i++) {
            elementToBeCompare = a[i];
            replaceElementIndex = i;
            for (int j = i - 1; j >= 0 && elementToBeCompare < a[j]; j--) {
                swapValues(a, j, replaceElementIndex);
                replaceElementIndex--;
            }
        }
    }
}
