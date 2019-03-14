package br.edu.ifpb.mensagem;

import java.util.Enumeration;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/03/2019, 10:51:30
 */
@Stateless
@LocalBean
public class LeitorDeMensagens {

//    @Resource(lookup = "jms/top")
//    private Topic queue;
    @Resource(lookup = "jms/aulaQueue")
    private Queue queue;

    @Inject
//    @JMSConnectionFactory("jms/MyConnectionFactory")
    private JMSContext context;

    public String ler(String destinatario) {

        try {
            JMSConsumer createConsumer = context.createConsumer(
                queue,"destino='" + destinatario + "'"
//               "destino='job'"
            );
            Message message = createConsumer.receive();
            String destino = message.getStringProperty("destino");
            String body = message.getBody(String.class);

//            QueueBrowser createBrowser = context.createBrowser(queue);
//            Enumeration enumeration = createBrowser.getEnumeration();
            
            return String.format(
                "destination: %s destino: %s, corpo: %s ",
                queue.getQueueName(),destino,body
            );
            
             
            
            
        } catch (JMSException | javax.ejb.TransactionRolledbackLocalException ex) {
//            Logger.getLogger(LeitorDeMensagens.class.getName()).log(Level.SEVERE,null,ex);
            return String.format(
                "codigo: %s, corpo: %s ",
                ex.toString(),ex.getMessage()
            );
        }

//        return "";
    }
}
