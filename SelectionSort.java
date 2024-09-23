public class SelectionSort {
        public static void selectionSort(Pedido[] arr) {
            int n = arr.length;
            Pedido temp;
            for (int i = 0; i < n - 1; i++) {
                int min = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j].data.before(arr[min].data)) {
                        min = j;
                    }
                }
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    
}
