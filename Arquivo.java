import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
    public void adicionarPreco(String caminho, float preco) {
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true));
        bw.write(String.valueOf(preco));
        bw.newLine();
        bw.close();
    } catch (IOException e) {
        System.out.println("Erro ao adicionar preço: " + e.getMessage());
    }
}
    public ArrayList<Float> lerPrecos (String caminho){
        ArrayList<Float> precos = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader (caminho));
            String linha;
            while ((linha = br.readLine()) != null) {
                precos.add(Float.parseFloat(linha));
            }
            br.close();
            
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return precos;
    }
    public void salvarResultados(String caminho, float maior, float menor) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(caminho));
            bw.write("Mais caro: R$" + maior);
            bw.newLine();
            bw.write("Mais barato: R$" + menor);
            bw.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}