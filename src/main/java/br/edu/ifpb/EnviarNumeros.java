package br.edu.ifpb;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/03/2019, 10:01:24
 */
@Stateless
public class EnviarNumeros {

    @Resource(lookup = "jms/aulaQueue")
    private Queue queue;

    @Inject
    private JMSContext context;

    public void enviar(int a,int b) {
        try {
            JMSProducer producer = context.createProducer();
            ObjectMessage createObjectMessage = context.createObjectMessage();
            createObjectMessage.setIntProperty("a",a);
            createObjectMessage.setIntProperty("b",b);
            producer.send(queue,createObjectMessage);
        } catch (JMSException ex) {
            Logger.getLogger(EnviarNumeros.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
