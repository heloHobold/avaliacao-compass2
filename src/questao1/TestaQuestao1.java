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
                case 1: // -> e se o usuário escolher essa opção várias vezes? Os dados serão duplicados!
                    Produto produto1 = new Produto();
                    produto1.setNome("Mouse");
                    produto1.setDescricao("Mouse sem fio");
                    produto1.setQuantidade(12);
                    produto1.setPreco(135.90);
                    produtoDAO.salvar(produto1);

                    Produto produto2 = new Produto();
                    produto2.setNome("Teclado");
                    produto2.setDescricao("Teclado mecânico RGB");
                    produto2.setQuantidade(10);
                    produto2.setPreco(212.99);
                    produtoDAO.salvar(produto2);

                    Produto produto3 = new Produto();
                    produto3.setNome("Monitor");
                    produto3.setDescricao("Monitor LG 27´´");
                    produto3.setQuantidade(4);
                    produto3.setPreco(1380.89);
                    produtoDAO.salvar(produto3);

                    System.out.println("\nInserção realizada!\n"); // -> em caso de erro na execução desse caso isso ainda será mostrado no console - Exceções?
                    System.out.println("Escolha uma outra opção!"); // -> em caso de erro na execução desse caso isso ainda será mostrado no console - Exceções?

                    break;

                case 2: // -> O que fazer quando ainda não tiver nada inserido no banco?

                    Produto p1 = new Produto();
                    p1.setNome("Luminária");
                    p1.setDescricao("Luminária de mesa articulada");
                    p1.setQuantidade(5);
                    p1.setPreco(99.90);

                    p1.setId(1);

                    produtoDAO.alterar(p1);

                    System.out.println("Escolha uma outra opção!"); //-> em caso de erro na execução desse caso isso ainda será mostrado no console - Exceções?

                    break;

                case 3:

                    produtoDAO.deletar(2);

                    System.out.println("Escolha uma outra opção!"); // -> em caso de erro na execução desse caso isso ainda será mostrado no console - Exceções?

                    break;

                default:
                    System.out.println("\nOpção inválida! Escolha uma opção válida!"); // -> uma exception para tratar da entrade de strings?
                    break;
            }
            opcao = leia.nextInt();
        }
        System.out.println("\nAplicação encerrada!");
    }
}

//for (Produto p : produtoDAO.listarProdutos()){
//        System.out.println(p.getId() + " | " + p.getNome() + ", descrição: " + p.getDescricao() + ", quantidade: " +
//        ", preço: "+ p.getPreco());
//        }
