import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
       List<String> pedidosCriados = new ArrayList<>();
       List<String> pedidosOrdenados = new ArrayList<>();

        System.out.println("Bem Vindo ao Organizador de Pedidos");
        while (true) {
            System.out.println("Escolha uma opção:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - criar pedidos");
            System.out.println("2 - ordenar pedidos");
            System.out.println("3 - mostrar pedidos ordenados");
            int opcao = scanner.nextInt();
            if(opcao == 1){
                System.out.println("Quantos pedidos deseja criar?");
                int quantidade = scanner.nextInt();
                pedidosCriados.add("pedidos_"+quantidade+".csv");
                CriarPedidos criarPedidos = new CriarPedidos(quantidade, null, null, quantidade);
                criarPedidos.criarPedido(quantidade);
            }else if(opcao == 2){
                System.out.println("Escolha um pedido par ordenar:");
                for (int i = 0; i < pedidosCriados.size(); i++) {
                    System.out.println(i + " - " + pedidosCriados.get(i));
                }
                int opcao3 = scanner.nextInt();

                System.out.println("Escolha uma opção:");
                System.out.println("1 - Ordenar por Bubble Sort");
                System.out.println("2 - Ordenar por Selection Sort");
                System.out.println("3 - Ordenar por Merge Sort");
                System.out.println("4 - Sair");
                int opcao2 = scanner.nextInt();
                if(opcao2 == 1){
                    try {
                        OrdenarPedido ordenarPedido = new OrdenarPedido();
                        ordenarPedido.ordenarBubble(pedidosCriados.get(opcao3));
                        pedidosOrdenados.add("pedidos_bubble.csv");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(opcao2 == 2){
                    try {
                        OrdenarPedido ordenarPedido = new OrdenarPedido();
                        ordenarPedido.selectionSort(pedidosCriados.get(opcao3));
                        pedidosOrdenados.add("pedidos_selectionSort.csv");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else if(opcao2 == 3){
                    try {
                        OrdenarPedido ordenarPedido = new OrdenarPedido();
                        ordenarPedido.ordenarMerge(pedidosCriados.get(opcao3));
                        pedidosOrdenados.add("pedidos_mergeSort.csv");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(opcao2 == 4){
                    scanner.close();
                    break;
                }
            }else if (opcao == 3){
                System.out.println("Escolha uma lista para mostrar:");
                for (int i = 0; i < pedidosOrdenados.size(); i++) {
                    System.out.println(i + " - " + pedidosOrdenados.get(i));
                }
                int opcao5 = scanner.nextInt();
                LeituraCSv.readCSV(pedidosOrdenados.get(opcao5));
            }

        }

    }
}
