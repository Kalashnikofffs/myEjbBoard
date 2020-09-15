import javax.annotation.Resource;

import javax.ejb.Stateful;
import javax.inject.Inject;

import javax.jms.Queue;
import javax.jms.JMSContext;


@Stateful
public class Sender
{
    @Resource(mappedName = "java:/jms/queue/MyQueue")
    private Queue queue;

    @Inject
    private JMSContext context;

    public void sendMessage(String txt) {
        context.createProducer().send(queue, txt);
    }
}
