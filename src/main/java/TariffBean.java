import models.Tariff;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("tarifBean")
@ViewScoped
public class TariffBean implements Serializable {


    @EJB
    private RestClient restClient;


    @Inject
    @Push(channel = "push")
    PushContext pushContext;

    public int getTariffsCount () {

        return restClient.getTariffs().size();
    }

    public String getDate () {
        Date date = new Date();

        return date.toString();
    }

    private List<Tariff> tariffs;

    public void setTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }



    public void update() {
        pushContext.send("updateTariffs");
    }

    public String getMessage() {
        return restClient.getTariffs().toString();
    }

    public List<Tariff> getTariffs() {
        return restClient.getTariffs();
    }

}
