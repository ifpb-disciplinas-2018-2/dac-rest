package br.edu.ifpb.mensagem;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
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
public class LeitorAssincrono implements MessageListener {

    // será executado sempre que existir uma nova mensagem
    @Override
    public void onMessage(Message message) {
        try {
            String destino = message.getStringProperty("destino");
            String body = message.getBody(String.class);
            System.out.println(
                String.format(
                    "LeitorAssincrono - destino: %s, corpo: %s ",
                    destino,body
                )
            );
        } catch (JMSException ex) {
            Logger.getLogger(LeitorAssincrono.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
