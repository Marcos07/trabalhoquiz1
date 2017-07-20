/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author wlysses & polliana
 */
public class Resposta {
    
private int id;
private String descricao;
private int id_pergunta;
private String comentario;


    public Resposta(int id, String descricao, int id_pergunta, String comentario) {
        this.id = id;
        this.descricao = descricao;
        this.id_pergunta = id_pergunta;
        this.comentario = comentario;
    }

    public Resposta() {
    }


    public String getComentario() {
        return comentario;
    }
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(int id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

    
    
}
