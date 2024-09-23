import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdenarPedido {
    String line = "";
    String csvSplitBy = ",";
    BufferedReader br;


    public void ordenarMerge(String inputfile) throws IOException, ParseException {
        br = new BufferedReader(new FileReader(inputfile));
        long startTime = System.currentTimeMillis();
        List<Pedido> pedidos = new ArrayList<>();
        br.readLine(); 

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while ((line = br.readLine()) != null) {
            String[] pedidoData = line.split(csvSplitBy);
            int id = Integer.parseInt(pedidoData[0]);
            String nome = pedidoData[1];
            Date data = dateFormat.parse(pedidoData[2]);
            double valor = Double.parseDouble(pedidoData[3]);
            pedidos.add(new Pedido(id, nome, data, valor));
        }

        Pedido[] pedidosArray = pedidos.toArray(new Pedido[0]);
        Pedido[] vetorAuxiliar = new Pedido[pedidosArray.length];

        MergeSort.mergSort(pedidosArray, vetorAuxiliar, 0, pedidosArray.length - 1);

        FileWriter writer = new FileWriter("pedidos_mergeSort.csv");
        writer.append("ID,Nome,Data,Valor\n");

        for (Pedido pedido : pedidosArray) {
            writer.append(pedido.toCSV()).append("\n");
        }

        writer.flush();
        writer.close();
        long endTime = System.currentTimeMillis(); 
        long duration = endTime - startTime;

        System.out.println("merge: " + duration + " ms");
    }

    public void ordenarBubble(String inputFile) throws IOException, ParseException {
        br = new BufferedReader(new FileReader(inputFile));
        long startTime = System.currentTimeMillis();
        List<Pedido> pedidos = new ArrayList<>();
        br.readLine(); 
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
        while ((line = br.readLine()) != null) {
            String[] pedidoData = line.split(csvSplitBy);
            int id = Integer.parseInt(pedidoData[0]);
            String nome = pedidoData[1];
            Date data = dateFormat.parse(pedidoData[2]);
            double valor = Double.parseDouble(pedidoData[3]);
            pedidos.add(new Pedido(id, nome, data, valor));
        }
    
        Pedido[] pedidosArray = pedidos.toArray(new Pedido[0]);
    
        BubbleSort.bubbleSort(pedidosArray);
    
        FileWriter writer = new FileWriter("pedidos_bubble.csv");
        writer.append("ID,Nome,Data,Valor\n");
    
        for (Pedido pedido : pedidosArray) {
            writer.append(pedido.toCSV()).append("\n");
        }
    
        writer.flush();
        writer.close();
        long endTime = System.currentTimeMillis(); 
        long duration = endTime - startTime; 
    
        System.out.println("bubble sort: " + duration + " ms");
    }

    public void selectionSort(String inputFile) throws IOException, ParseException {
        br = new BufferedReader(new FileReader(inputFile));
        long startTime = System.currentTimeMillis();
        List<Pedido> pedidos = new ArrayList<>();
        br.readLine(); 

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while ((line = br.readLine()) != null) {
            String[] pedidoData = line.split(csvSplitBy);
            int id = Integer.parseInt(pedidoData[0]);
            String nome = pedidoData[1];
            Date data = dateFormat.parse(pedidoData[2]);
            double valor = Double.parseDouble(pedidoData[3]);
            pedidos.add(new Pedido(id, nome, data, valor));
        }

        Pedido[] pedidosArray = pedidos.toArray(new Pedido[0]);

        SelectionSort.selectionSort(pedidosArray);

        FileWriter writer = new FileWriter("pedidos_selectionSort.csv");
        writer.append("ID,Nome,Data,Valor\n");

        for (Pedido pedido : pedidosArray) {
            writer.append(pedido.toCSV()).append("\n");
        }

        writer.flush();
        writer.close();
        long endTime = System.currentTimeMillis(); 
        long duration = endTime - startTime;

        System.out.println("selection sort: " + duration + " ms");
    }
    /* 
    public static void main(String[] args) {
        try {
            OrdenarPedido ordenarPedido = new OrdenarPedido();
            ordenarPedido.ordenarMerge();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        try {
            OrdenarPedido ordenarPedido = new OrdenarPedido();
            ordenarPedido.ordenarBubble();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        try {
            OrdenarPedido ordenarPedido = new OrdenarPedido();
            ordenarPedido.selectionSort();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }*/
}

class Pedido {
    int id;
    String nome;
    Date data;
    double valor;

    public Pedido(int id, String nome, Date data, double valor) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
    }

    public String toCSV() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return id + "," + nome + "," + dateFormat.format(data) + "," + valor;
    }
}
