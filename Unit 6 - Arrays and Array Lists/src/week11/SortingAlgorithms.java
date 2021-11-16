package week11;

public class SortingAlgorithms {
    public static void main (String[] args) {
        int[] arr = {30, 20, 5, 70, 90, 85, 10};
        int[] aar = {30, 20, 5, 70, 90, 85, 10};

        selectionSort(arr);
        insertionSort(aar);
    }
    
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && temp < arr[j - 1]; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){ // divides sorted -||- unsorted
            int smol = i;
            for (int j = i; j < arr.length; j++){ // selects smallest of unsorted
                if (arr[j] < arr[smol]){
                    smol = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smol];
            arr[smol] = temp;
        }
    }
}
