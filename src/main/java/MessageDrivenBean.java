//import lombok.extern.slf4j.Slf4j;

import lombok.extern.slf4j.Slf4j;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;


@MessageDriven(name = "Consumer" , activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName="destination", propertyValue="java:/jms/queue/MyQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")

})
public class MessageDrivenBean implements MessageListener {


    @Inject
    private RestClient restClient;

    @Inject
    private TariffBean tariffBean;

    @Inject
    @Push(channel = "push")
    private PushContext pushContext;


    @Override
    public void onMessage(Message message) {

        tariffBean.update();
        System.out.println("MessageDriveRecived  " + message.toString());
        restClient.getTariffs();
//        push.send("pushed");

    }
}
