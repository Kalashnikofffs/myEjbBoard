import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import models.Tariff;

import javax.ejb.Singleton;
import javax.enterprise.context.SessionScoped;
import java.util.List;


@Singleton
public class RestClient {

    public List<Tariff> getTariffs() {

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);


        WebResource webResource = client.resource("http://localhost:8080/eCare555_war_exploded/rest/tariffs");


        List<Tariff> tariffs = webResource.type("application/json").get(new GenericType<List<Tariff>>() {
        });

        return tariffs;

    }
}
