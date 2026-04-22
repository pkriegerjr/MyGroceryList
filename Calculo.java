
import java.util.ArrayList;

//Calcular qual o mais Barato e o mais Caro
public class Calculo{
    private float Maior;
    private float Menor;
    private float Num;

    //Numeros gerados
    public float getNum() {
        return Num;
    }

    //Vai Identificar uma Exception de Calculo
    public ArrayList<Float> validarLista(ArrayList<Float> atacados) {
    ArrayList<Float> listaValida = new ArrayList<>();
    for (float preco : atacados) {
        try {
            Validarpreco(preco);
            listaValida.add(preco); // só adiciona se for válido
        } catch (CalculoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    return listaValida;
}

    //Qual o mais caro
    public float getMaior(ArrayList<Float> atacados){
       Maior = (float) atacados.stream()
                       .mapToDouble(Float::doubleValue)
                       .max()
                       .orElseThrow(() -> new RuntimeException("Lista vazia!"));
        return Maior;
    }

    //Qual é o mais barato
    public float getMenor(ArrayList<Float> atacados) {
        Menor = (float) atacados.stream()
                        .mapToDouble(Float::doubleValue)
                        .min()
                        .orElseThrow(() -> new RuntimeException("Lista vazia!"));
        return Menor;
    }
    public static void Validarpreco(float Num) throws CalculoException{
        if (Num < 0){
            throw new CalculoException("Numero Negativo: " + Num);
            
        }
    }
}