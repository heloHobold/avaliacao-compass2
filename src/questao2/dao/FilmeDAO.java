package questao2.dao;

import factory.ConnectionFactory;
import questao2.TestaQuestao2;
import questao2.modelo.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    public static List<Filme> listarFilmes() {
        String sql = "SELECT * FROM filme";

        List<Filme> filmes = new ArrayList<Filme>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;

        try {
            conn = ConnectionFactory.criarConexao();

            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while (rst.next()){
                Filme filme = new Filme();

                filme.setId(rst.getInt("id"));
                filme.setNome(rst.getString("nome"));
                filme.setDescricao(rst.getString("descricao"));
                filme.setAno(rst.getString("ano"));

                filmes.add(filme);
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
        return filmes;
    }

    public static List<Filme> filtarFilmes(int qtdFilmes) {
        String sql = "SELECT * FROM filme LIMIT ?";

        List<Filme> filmes = new ArrayList<Filme>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;

        try {
            conn = ConnectionFactory.criarConexao();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, qtdFilmes);

            rst = pstm.executeQuery();

            while (rst.next()){
                Filme filme = new Filme();

                filme.setId(rst.getInt("id"));
                filme.setNome(rst.getString("nome"));
                filme.setDescricao(rst.getString("descricao"));
                filme.setAno(rst.getString("ano"));

                filmes.add(filme);
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
        return filmes;
    }
}
