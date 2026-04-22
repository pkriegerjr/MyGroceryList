//O Software está apenas adicionando os valores sem distinguir de que produto estou adicionando, irei adicionar na proxima versão

import java.util.ArrayList;
import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        System.out.println("Bem vindos");
        Arquivo Lista  = new Arquivo();
        Calculo preco = new Calculo();
        
        int op = 0;
        Scanner scanner = new Scanner(System.in); 

        //opções do sistema
        while (op != 3){
    System.out.println("\n1 - Adicionar preço");
    System.out.println("2 - Calcular maior e menor");
    System.out.println("3 - Sair");
    System.out.print("Escolha: ");
    op = scanner.nextInt();
    scanner.nextLine();

switch (op) {
    //adicionando preços
    case 1 :
        System.out.println("Digite 0 para sair");
    float precoAtacado = 1;
    
    while (precoAtacado != 0) {
        System.out.print("Digite o preço: ");
        precoAtacado = scanner.nextFloat();
        scanner.nextLine();

        // só adiciona se não for 0
        if (precoAtacado != 0) {
            Lista.adicionarPreco("ListaAtacados.txt", precoAtacado);
            System.out.println("Preço adicionado!");
        }
    }
    break;

    case 2 :
        //Lê os preços da lista
        ArrayList <Float> precos = Lista.lerPrecos("ListaAtacados.txt");

        //Valida os preços da lista
        ArrayList <Float> precosValidos = preco.validarLista(precos);

        //Calculo de preços
        Calculo calculo = new Calculo();
        float Menor = calculo.getMenor(precosValidos);
        float Maior = calculo.getMaior(precosValidos);
        System.out.println("Mais caro é: R$" + Maior);
        System.out.println("Mais barato é: R$" + Menor);
        break;

    case 3:
            System.out.println("Saindo...");
            break;
}
        }
        scanner.close();
    }
}
