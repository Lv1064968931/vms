package com.lvlin.vms.entity;

import java.io.Serializable;

public class VaccineFunction implements Serializable {
    private Integer id;
    private String name;
    private String function;
    private String taboo;
    private String standard;
    private String untowardEffect;
    private String objectVaccine;

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

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getTaboo() {
        return taboo;
    }

    public void setTaboo(String taboo) {
        this.taboo = taboo;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getUntowardEffect() {
        return untowardEffect;
    }

    public void setUntowardEffect(String untowardEffect) {
        this.untowardEffect = untowardEffect;
    }

    public String getObjectVaccine() {
        return objectVaccine;
    }

    public void setObjectVaccine(String objectVaccine) {
        this.objectVaccine = objectVaccine;
    }
}
