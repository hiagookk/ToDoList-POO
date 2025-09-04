package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private LocalDateTime dataAgora;

    // Construtores
    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.completa = false;
        this.dataAgora = LocalDateTime.now();
    }
    
    
    
    // getters e setters
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public LocalDateTime getDataAgora() {
        return dataAgora;
    }

    public void setDataAgora(LocalDateTime dataAgora) {
        this.dataAgora = dataAgora;
    }
}