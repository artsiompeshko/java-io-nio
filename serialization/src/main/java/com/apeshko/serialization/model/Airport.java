package com.apeshko.serialization.model;

import java.io.Serializable;

public class Airport implements Serializable {
    private String name;
    private transient long latitude;
    private transient long longitude;

    public Airport(String name, long latitude, long longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }
}
