package br.com.zupacademy.william.casadocodigo.livro;

public class LivroDtoApenasNome {

    private Long id;
    private String titulo;

    public LivroDtoApenasNome(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
