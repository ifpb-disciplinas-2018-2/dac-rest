package br.edu.ifpb.produto;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/03/2019, 10:12:50
 */
@Stateless
public class ServiceProduto {

    @PersistenceContext
    private EntityManager em;

    public List<Produto> todos() {
//        List<Produto> lista = Arrays.asList(
//            new Produto(1,"TV",2500d),
//            new Produto(2,"Arroz",1.60d),
//            new Produto(3,"carne",20d)
//        );
//        return lista;
        return em.createQuery("From Produto p",Produto.class)
            .getResultList();
    }

    public Produto localizar(int id) {
//        return todos().stream()
//            .filter(p -> p.getId() == id)
//            .findFirst()
//            .orElseGet(Produto::empty);
        Produto find = em.find(Produto.class,id);
        if (find == null) {
            return Produto.empty();
        }
        return find;
    }

    public Produto salvar(Produto produto) {
//        produto.setId(todos().size() + 1);// novo id
//        return produto;
        em.persist(produto);
        return produto;
    }

    public boolean remover(int id) {
        Produto find = em.find(Produto.class,id);
        if (find == null) {
            return false;
        }
        em.remove(find);
        return true;
    }

    public Produto atualizar(int id,Produto produto) {
        Produto find = em.find(Produto.class,id);
        if (find == null) {
            return Produto.empty();
        }
        find = produto;
        find.setId(id);

        return em.merge(find);
    }
}
