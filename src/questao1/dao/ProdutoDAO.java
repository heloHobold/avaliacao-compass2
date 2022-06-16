package questao1.dao;

import factory.ConnectionFactory;
import questao1.modelo.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao, quantidade, preco)" +
                "VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.criarConexao();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setInt(3, produto.getQuantidade());
            pstm.setDouble(4, produto.getPreco());

            pstm.execute();

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

            pstm.setInt(5, produto.getId());

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

    public void deletar (int id) {

        String sql = "DELETE FROM produto WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.criarConexao();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

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

    public List<Produto> listarProdutos() {
        String sql = "SELECT * FROM produto";

        List<Produto> produtos = new ArrayList<Produto>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;

        try {
            conn = ConnectionFactory .criarConexao();

            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while (rst.next()){
                Produto produto = new Produto();

                produto.setId(rst.getInt("id"));
                produto.setNome(rst.getString("nome"));
                produto.setDescricao(rst.getString("descricao"));
                produto.setQuantidade(rst.getInt("quantidade"));
                produto.setPreco(rst.getDouble("preco"));

                produtos.add(produto);
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
        return produtos;
    }

}
