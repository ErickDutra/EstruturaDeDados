import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

public class CriarPedidos {
    private int id;
    private String nome;
    private Date date;
    private double valor;

    public CriarPedidos(int id, String nome, Date date, double valor) {
        this.id = id;
        this.nome = nome;
        this.date = (date == null) ? generateRandomDate() : date;
        this.valor = valor;
    }
    
    private Date generateRandomDate() {
        Random random = new Random();
        Calendar calendar = Calendar.getInstance();
        
        int currentYear = calendar.get(Calendar.YEAR);
        int randomYear = currentYear - random.nextInt(10);
        
        int randomMonth = random.nextInt(12);
        
        calendar.set(Calendar.YEAR, randomYear);
        calendar.set(Calendar.MONTH, randomMonth);
        
        int randomDay = random.nextInt(calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
        calendar.set(Calendar.DAY_OF_MONTH, randomDay);
        
        return calendar.getTime();
    }
    
    private int generateValor() {
        Random random = new Random();
        return random.nextInt(10000) + 1;   
    }

    public void criarPedido(int quantidade){
        try {
            FileWriter writer = new FileWriter("pedidos_"+quantidade+".csv");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            writer.append("ID,Nome,Data,Valor\n");
            
            for (int i = 1; i <= quantidade; i++) {
                CriarPedidos pedido = new CriarPedidos(i, "Cliente" + i, null, new CriarPedidos(0, null, null, 0).generateValor());
                String formattedDate = dateFormat.format(pedido.date);
                writer.append(pedido.id + "," + pedido.nome + "," + formattedDate + "," + pedido.valor + "\n");
            }
            
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}