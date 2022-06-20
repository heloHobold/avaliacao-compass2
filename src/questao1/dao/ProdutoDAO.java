package questao1.dao;

import factory.ConnectionFactory;
import questao1.modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.Random;

public class ProdutoDAO {
    private final String[] produtos = {
            "'Mouse', 'Mouse sem fio', 12, 135.90",
            "'Teclado', 'Teclado RGB', 6, 212.99",
            "'Monitor', 'Monitor LG 27´´', 3, 1380.89",
            "'Luminária', 'Luminária de mesa articulada', 5, 99.90",
            "'Mouse Pad', 'Preto 70x30', 5, 82.00",
            "'Suporte de monitor', 'Suporte articulado 2 telas', 4, 380.90",
            "'Headset', 'Headset Gamer', 8, 309.90",
            "'Impressora', 'Impressora EPSON', 4, 1100.80",
            "'Fone bluetooth', 'Fone bluetooth Lenovo', 9, 99.90",
            "'Smartphone Poco', 'Poco M4 Pro 5G ', 3, 1527.80",
            "'Notebook Dell', 'Notebook Inspiron 15 3000', 2, 3691.80",
            "'SMART TV Samsung', 'SMART TV 55´´', 12, 135.90",
            "'Echo Dot (4ª Geração)', 'Preta, com Alexa', 8, 280.18",
            "'Webcam Logitech', 'Full HD Microfone Embutido', 7, 379.90",
            "'Roteador Wireless', 'Gigabit-Ethernet com 4 Antenas', 3, 207.80"
    };


    public void inserir3ProdutosAleatorios() {

        Random gerador = new Random();

        String sql = "INSERT INTO produto (nome, descricao, quantidade, preco) VALUES (" + produtos[gerador.nextInt(15)] + "), ("+ produtos[gerador.nextInt(15)]
        + "), (" + produtos[gerador.nextInt(15)] + ")";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.criarConexao();

            pstm = conn.prepareStatement(sql);
            pstm.execute();

            System.out.println("\nInserção realizada!\n");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void alterar (Produto produto) {


        String sql = "UPDATE produto SET nome = ?, descricao = ?, quantidade = ?, preco = ?" +
                "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.criarConexao();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setInt(3, produto.getQuantidade());
            pstm.setDouble(4, produto.getPreco());

            pstm.setInt(5, (getUltimoId()-2));

            pstm.execute();
            System.out.println("\nAtualização realizada!\n");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deletar () {

        String sql = "DELETE FROM produto WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.criarConexao();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, (getUltimoId()-1));

            pstm.execute();
            System.out.println("\nExclução realizada!\n");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getUltimoId(){
        String sql = "SELECT MAX(id) AS id FROM produto";

        int idFinal = 0;

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;

        try{
            conn = ConnectionFactory.criarConexao();
            pstm = conn.prepareStatement(sql);
            rst = pstm.executeQuery();
            while(rst.next()) {
                idFinal = rst.getInt("id");
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (rst != null){
                    rst.close();
                }

                if (pstm != null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return idFinal;
    }
}
