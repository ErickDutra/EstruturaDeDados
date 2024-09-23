import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeituraCSv{


    public static void readCSV(String fileName) {
        String line = "";
        String csvSplitBy = ",";
    
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                String[] pedido = line.split(csvSplitBy);
                System.out.println("ID: " + pedido[0] + ", Nome: " + pedido[1] + ", Data: " + pedido[2] + ", Valor: " + pedido[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}