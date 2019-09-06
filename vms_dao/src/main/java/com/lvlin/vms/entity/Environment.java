package com.lvlin.vms.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Environment {
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    private Date time;
    private String temperature;
    private String humidity;
    private String illumination;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getIllumination() {
        return illumination;
    }

    public void setIllumination(String illumination) {
        this.illumination = illumination;
    }
}
