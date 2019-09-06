package com.lvlin.vms.entity;

public class VaccineEnvironment {
    private Integer id;
    private String name;
    private String minTem;
    private String maxTem;
    private String minHum;
    private String maxHum;
    private String minIllu;
    private String maxIllu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinTem() {
        return minTem;
    }

    public void setMinTem(String minTem) {
        this.minTem = minTem;
    }

    public String getMaxTem() {
        return maxTem;
    }

    public void setMaxTem(String maxTem) {
        this.maxTem = maxTem;
    }

    public String getMinHum() {
        return minHum;
    }

    public void setMinHum(String minHum) {
        this.minHum = minHum;
    }

    public String getMaxHum() {
        return maxHum;
    }

    public void setMaxHum(String maxHum) {
        this.maxHum = maxHum;
    }

    public String getMinIllu() {
        return minIllu;
    }

    public void setMinIllu(String minIllu) {
        this.minIllu = minIllu;
    }

    public String getMaxIllu() {
        return maxIllu;
    }

    public void setMaxIllu(String maxIllu) {
        this.maxIllu = maxIllu;
    }
}
