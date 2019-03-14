package br.edu.ifpb;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/03/2019, 09:22:40
 */
@Stateless
public class Calculadora {

    @Resource
    private ManagedExecutorService mes;

    public int somar(int a,int b) {

        Future<Integer> future = mes.submit(
            new ProcessamentoLongo(a,b)
        );
        System.out.println("estoy aki!!");
        try {
            Integer resposta = future.get();
            return resposta;
        } catch (InterruptedException | ExecutionException ex) {
            throw new IllegalStateException("deu ruim",ex);
        }
        
    }
}

class ProcessamentoLongo implements Callable<Integer> {

    private int a;
    private int b;

    public ProcessamentoLongo(int a,int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("já começou!!!");
        Thread.sleep(10000);// exemplificar o processamento
        System.out.println("já acordei!!!!");
        return a + b;
    }

}
