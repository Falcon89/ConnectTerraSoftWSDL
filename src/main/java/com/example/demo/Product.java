package com.example.demo;

import javax.xml.bind.JAXBElement;

public class Product {
    private String name;
    private Integer index;

    public Product(JAXBElement<String> name, JAXBElement<Integer> index) {
        this.name = name.getValue();
        this.index = index.getValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
