package questao1;

import questao1.dao.ProdutoDAO;
import questao1.modelo.Produto;

import java.util.Scanner;

public class TestaQuestao1 {
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);

        System.out.println("Escolha uma opção: ");
        System.out.println("1 - Cadastrar 3 produtos na base de dados");
        System.out.println("2 - Atualizar o primeiro produto cadastrado pela opção 1");
        System.out.println("3 - Excluir o segundo produto cadastrado");
        System.out.println("0 - Encerrar aplicação!");
        int opcao = leia.nextInt();

        ProdutoDAO produtoDAO = new ProdutoDAO();

        while (opcao != 0){
            switch (opcao) {
                case 1:
                    produtoDAO.inserir3ProdutosAleatorios();
                    System.out.println("Escolha uma outra opção!");
                    break;

                case 2:
                    Produto p1 = new Produto();
                    p1.setNome("Monitor");
                    p1.setDescricao("Monitor SAMSUNG curvo");
                    p1.setQuantidade(5);
                    p1.setPreco(1500.00);
                    p1.setId(1);
                    produtoDAO.alterar(p1);
                    System.out.println("Escolha uma outra opção!");
                    break;

                case 3:
                    produtoDAO.deletar();
                    System.out.println("Escolha uma outra opção!");
                    break;

                default:
                    System.out.println("\nOpção inválida! Escolha uma opção válida!");
                    break;
            }
            opcao = leia.nextInt();
        }
        System.out.println("\nAplicação encerrada!");
    }
}