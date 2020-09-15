package models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Tariff implements Serializable {
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

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options = options;
    }

    private Long id;
    private String title;
    private Integer price;
    private Set<Option> options = new HashSet<>();

    public Tariff() {
    }

    public Tariff(String title, int price) {
        this.title = title;
        this.price = price;
    }

}
