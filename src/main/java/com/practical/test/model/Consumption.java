package com.practical.test.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Consumption {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
