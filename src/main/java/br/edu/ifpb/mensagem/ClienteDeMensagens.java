package br.edu.ifpb.mensagem;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/03/2019, 09:49:04
 */
@Stateless // RPC - Sincrona
@LocalBean
public class ClienteDeMensagens {

    @EJB
//    private EnviaMensagemCustosa cliente;
    private EnviaMensagemComJMS cliente;

    
    @EJB
    private LeitorDeMensagens leitor;
    
    // Se este método demorar? 
    public String enviarMensagem(String destinatario,String corpo) {
        return this.cliente.enviar(destinatario,corpo);
    }
    
    public String ler(String destinatario){
        return this.leitor.ler(destinatario);
    }

}
