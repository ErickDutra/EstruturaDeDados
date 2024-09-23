
class MergeSort {
    public static void mergSort(Pedido[] arr, Pedido[] vetorAuxiliar, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergSort(arr, vetorAuxiliar, inicio, meio);
            mergSort(arr, vetorAuxiliar, meio + 1, fim);
            intercalar(arr, vetorAuxiliar, inicio, fim, meio);
        }
    }

    private static void intercalar(Pedido[] arr, Pedido[] vetorAuxiliar, int inicio, int fim, int meio) {
        for (int k = inicio; k <= fim; k++)
            vetorAuxiliar[k] = arr[k];
        

        int i = inicio;
        int j = meio + 1;

        for (int k = inicio; k <= fim; k++) {
            if (i > meio)arr[k] = vetorAuxiliar[j++];
            else if (j > fim) arr[k] = vetorAuxiliar[i++];
            else if (vetorAuxiliar[i].data.before(vetorAuxiliar[j].data)) arr[k] = vetorAuxiliar[i++];
            else arr[k] = vetorAuxiliar[j++];  
        }
    }
}