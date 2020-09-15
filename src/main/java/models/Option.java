package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Option implements Serializable {

    private Long id;
    private String title;
    private Integer price;
    private Integer costOfConnection;
    private Tariff tariff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCostOfConnection() {
        return costOfConnection;
    }

    public void setCostOfConnection(Integer costOfConnection) {
        this.costOfConnection = costOfConnection;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public Set<Option> getDependentOptions() {
        return dependentOptions;
    }

    public void setDependentOptions(Set<Option> dependentOptions) {
        this.dependentOptions = dependentOptions;
    }

    public Set<Option> getIncompatibleOptions() {
        return incompatibleOptions;
    }

    public void setIncompatibleOptions(Set<Option> incompatibleOptions) {
        this.incompatibleOptions = incompatibleOptions;
    }

    private Set<Option> dependentOptions = new HashSet<>();
    private Set<Option> incompatibleOptions = new HashSet<>();

    public Option() {
    }

    public Option(Tariff tariff, String title, Integer price, Integer costOfConnection) {
        this.tariff = tariff;
        this.title = title;
        this.price = price;
        this.costOfConnection = costOfConnection;
    }
}


