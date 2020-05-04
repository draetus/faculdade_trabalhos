package com.univali.listadecompras.entities;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private Boolean inShopList;

    public Product(String name, Boolean inShopList) {
        this.name = name;
        this.inShopList = inShopList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInShopList() {
        return inShopList;
    }

    public void setInShopList(Boolean inShopList) {
        this.inShopList = inShopList;
    }
}
