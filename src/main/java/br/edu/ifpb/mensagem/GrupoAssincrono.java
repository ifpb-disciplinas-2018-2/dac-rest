package br.edu.ifpb.mensagem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 14/03/2019, 07:42:52
 */
@MessageDriven(
    mappedName = "jms/top",
    activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",
                                  propertyValue = "javax.jms.Topic")
        ,@ActivationConfigProperty(propertyName = "destinationLookup",
                                  propertyValue = "jms/top")
        ,@ActivationConfigProperty(propertyName = "destination",
                                  propertyValue = "topic")
        ,@ActivationConfigProperty(propertyName = "messageSelector",
                                  propertyValue = "destino='job'")
    }
)
public class GrupoAssincrono implements MessageListener {

    @EJB
    private EnviaMensagemCustosa mensagemCustosa;
    
    // será executado sempre que existir uma nova mensagem
    @Override
    public void onMessage(Message message) {
        try {
            String destino = message.getStringProperty("destino");
            String body = message.getBody(String.class);
//            System.out.println(
//                String.format(
//                    "GrupoAssincrono - destino: %s, corpo: %s ",
//                    destino,body
//                )
//            );
             System.out.println("começou o processamento");   
             System.out.println(mensagemCustosa.enviar(destino,body));
             System.out.println("finalizou o processamento");   
        } catch (JMSException ex) {
            Logger.getLogger(GrupoAssincrono.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
