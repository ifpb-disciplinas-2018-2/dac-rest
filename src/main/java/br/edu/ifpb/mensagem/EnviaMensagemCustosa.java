package br.edu.ifpb.mensagem;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/03/2019, 10:07:29
 */
@Stateless // RPC - Sincrona
@LocalBean
public class EnviaMensagemCustosa {

    @Resource
    private ManagedExecutorService mes;

    // Se este método demorar? 
    public String enviar(String destinatario,String corpo) {
        try {
            Future<String> submit = mes.submit(new EnvioDeMensagem());
            // sincronizando
            String get = submit.get();
            return get;
        } catch (InterruptedException | ExecutionException ex) {
            throw new IllegalStateException("deu ruim",ex);
        }
    }
}

class EnvioDeMensagem implements Callable<String> {

    @Override
    public String call() throws Exception {
        // metodo para exemplificar a demora no processamento
        Thread.sleep(10000);
        return java.util.UUID.randomUUID().toString();
    }

}
