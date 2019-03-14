package br.edu.ifpb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/03/2019, 10:01:35
 */
//@MessageDriven(
//    mappedName = "jms/aulaQueue",
//    activationConfig = {
//        @ActivationConfigProperty(propertyName = "destinationType",
//                                  propertyValue = "javax.jms.Queue")
//        ,@ActivationConfigProperty(propertyName = "destinationLookup",
//                                  propertyValue = "jms/aulaQueue")
//        ,@ActivationConfigProperty(propertyName = "destination",
//                                  propertyValue = "queue")
//    }
//) // Responsável por realizar o processamento custoso 
public class LerNumeros {//implements MessageListener {

//    @Inject
//    private Calculadora calculadora;
//
//    @Override
//    public void onMessage(Message message) {
//        try {
//            System.out.println("recebida!");
//            int a = message.getIntProperty("a");
//            int b = message.getIntProperty("b");
//            System.out.println("começar");
//            int soma = calculadora.somar(a,b);
//            System.out.println("processada!");
//        } catch (JMSException ex) {
//            Logger.getLogger(LerNumeros.class.getName()).log(Level.SEVERE,null,ex);
//        }
//
//    }

}
