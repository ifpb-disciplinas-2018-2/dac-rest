package br.edu.ifpb.mensagem;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Message;
import javax.jms.Topic;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/03/2019, 10:14:50
 */
@Stateless
@LocalBean
public class EnviaMensagemComJMS {

//    @Resource(lookup = "jms/aulaQueue")
//    private Queue destination;
    @Resource(lookup = "jms/top")
    private Topic destination;

//    @Resource(lookup = "jms/aulaConnectionFactory")
//    private ConnectionFactory factory;
    @Inject
    private JMSContext context;

    public String enviar(String destinatario,String corpo) {
        try {
            System.out.println("--enviando a mensagem----");
//            JMSContext context = factory.createContext();
            JMSProducer createProducer = context.createProducer();
            Message message = context.createTextMessage(corpo);
            message.setStringProperty("destino",destinatario);
            createProducer.send(
                destination,message
            );
            System.out.println("--mensagem enviada----");
            return " JMS " + java.util.UUID.randomUUID().toString();
        } catch (JMSException ex) {
            throw new IllegalStateException("erro ao criar a mensagem",ex);
        }
    }
}
