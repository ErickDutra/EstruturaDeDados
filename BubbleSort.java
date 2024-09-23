public class BubbleSort {

    public static void bubbleSort(Pedido[] arr) {
        int n = arr.length;
        Pedido temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1].data.after(arr[j].data)) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
