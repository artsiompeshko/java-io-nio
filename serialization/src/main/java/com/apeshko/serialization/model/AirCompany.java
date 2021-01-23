package com.apeshko.serialization.model;

import java.io.Serializable;
import java.util.List;

public class AirCompany implements Serializable {
    private String name;
    private List<FlyingMachine> flyingMachines;

    public AirCompany(String name, List<FlyingMachine> flyingMachines) {
        this.name = name;
        this.flyingMachines = flyingMachines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlyingMachine> getFlyingMachines() {
        return flyingMachines;
    }

    public void setFlyingMachines(List<FlyingMachine> flyingMachines) {
        this.flyingMachines = flyingMachines;
    }
}
