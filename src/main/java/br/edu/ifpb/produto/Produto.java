package br.edu.ifpb.produto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/03/2019, 10:08:41
 */
@Entity
@XmlRootElement
public class Produto implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String descricao;
    private double valor;

    public Produto() {
    }

    public Produto(int id,String descricao,double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public static Produto empty() {
        return new Produto(-1,"",0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
