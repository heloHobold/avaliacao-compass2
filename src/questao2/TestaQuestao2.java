package questao2;

import questao2.dao.FilmeDAO;
import questao2.modelo.Filme;

import java.util.Scanner;

public class TestaQuestao2 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Informe quantos filmes você deseja filtrar: ");
        int qtdFilmes = leia.nextInt();
        System.out.println("Informe o número da página você deseja acessar: ");
        int pagina = leia.nextInt();

        FilmeDAO filmeDAO = new FilmeDAO();

        for (Filme f : FilmeDAO.filtarFilmes(qtdFilmes)){
        System.out.println(f.getId() + " | " + f.getNome() + ", descrição: " + f.getDescricao() + ", ano: " + f.getAno());
        }

    }
}
