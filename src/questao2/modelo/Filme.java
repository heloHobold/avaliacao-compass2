package questao2.modelo;

public class Filme {
    private Integer id;
    private String nome;
    private String descricao;
    private String ano;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String  getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
}
