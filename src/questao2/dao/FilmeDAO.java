package questao2.dao;

import factory.ConnectionFactory;
import questao2.modelo.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

    public static List<Filme> filtrarFilmes(int qtdFilmes, int pagina) {

        int comecoPagina;
        int fimPagina;

        String sql= "SELECT * FROM filme WHERE id > ? AND id <= ? LIMIT ?";

        List<Filme> filmes = new ArrayList<Filme>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;

        try {
            if (pagina > 0 && pagina <= 4) {
                if (pagina == 1){
                    comecoPagina = 0;
                    fimPagina = 10;
                } else if (pagina == 2) {
                    comecoPagina = 10;
                    fimPagina = 20;
                } else if (pagina == 3) {
                    comecoPagina = 20;
                    fimPagina = 30;
                } else {
                    comecoPagina = 30;
                    fimPagina = 40;
                }

                conn = ConnectionFactory.criarConexao();

                pstm = conn.prepareStatement(sql);
                pstm.setInt(1, comecoPagina);
                pstm.setInt(2, fimPagina);
                pstm.setInt(3, qtdFilmes);

                rst = pstm.executeQuery();

                while (rst.next()) {
                    Filme filme = new Filme();

                    filme.setId(rst.getInt("id"));
                    filme.setNome(rst.getString("nome"));
                    filme.setDescricao(rst.getString("descricao"));
                    filme.setAno(rst.getString("ano"));

                    filmes.add(filme);
                }
            } else {
                System.out.println("Número de página inválido! Tente páginas de 1 a 4!");
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
