package br.edu.ifpb.produto;

import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 18/03/2019, 10:16:04
 */
@Stateless
@Path("produtos")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ResourceProduto {

    @Inject
    private ServiceProduto service;
    @Context
    private UriInfo uriInfo;

    // .../produtos
    @GET
//    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response listarProdutos() {

        List<Produto> resposta = this.service.todos();
        GenericEntity<List<Produto>> lista = new GenericEntity<List<Produto>>(resposta) {
        };
        return Response.ok()
            .entity(lista)
            .build();
    }

    // .../produtos/id
    @GET
    @Path("{idProduto}")
//    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response listarProduto(
        @PathParam("idProduto") int id) {

        Produto resposta = this.service.localizar(id);
        return Response.ok()
            .entity(resposta)
            .build();
    }

    @POST
//    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response novoProduto(Produto produto) {
        Produto resposta = this.service.salvar(produto);
        //http://localhost:8080/dac-webservice/api/produtos
        String id = String.valueOf(produto.getId());
        URI location = uriInfo.getAbsolutePathBuilder()
            .path(id) //../api/produtos/4
            .build();

            // 201 
        return Response.created(location) // a uri onde podemos encontrar o recurso criado
            .entity(resposta)
            .build();
    }

    // .../produtos/id
    @DELETE
    @Path("{id}")
//    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response removerProduto(
        @PathParam("id") int id) {

        boolean resposta = this.service.remover(id);

        if (resposta) {
            // 204
            return Response.noContent()
                .build();
        }
        // 304
        return Response.notModified("nada aconteceu")
            .build();
    }

    @PUT
    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response atualizarProduto(Produto produto,@PathParam("id") int id) {
        Produto resposta = this.service.atualizar(id,produto);
        return Response.ok()
            .entity(resposta)
            .build();
    }
}
