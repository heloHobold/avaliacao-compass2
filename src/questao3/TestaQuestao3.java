package questao3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestaQuestao3 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Escreva uma mensagem!");
        String mensagem = leia.nextLine();
        String divertido = ":-)";
        String chateado = ":-(";

        if (mensagem.contains(divertido) && mensagem.contains(chateado)){

            Matcher d = Pattern.compile("(divertido)",Pattern.DOTALL).matcher(mensagem);
            int quantidadeDivertido = 0;
            while (d.find()) quantidadeDivertido++;
            Matcher c = Pattern.compile("(chateado)",Pattern.DOTALL).matcher(mensagem);
            int quantidadeChateado = 0;
            while (c.find()) quantidadeDivertido++;

            if (quantidadeDivertido > quantidadeChateado){
                System.out.println("Divertido!");
            } else if (quantidadeDivertido < quantidadeChateado){
                System.out.println("Chateado!");
            } else {
                System.out.println("Neutro!");
            }

        } else if (mensagem.contains(divertido) && !mensagem.contains(chateado)) {
            System.out.println("Divertido!");
        } else if (!mensagem.contains(divertido) && mensagem.contains(chateado)) {
            System.out.println("Chateado!");
        } else {
            System.out.println("Neutro");
        }
    }
}
