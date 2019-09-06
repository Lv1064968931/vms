package com.lvlin.vms.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Vaccine {
    private Integer id;
    private String rfidSn;
    private String name;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productionDate;
    private String guaranteeDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRfidSn() {
        return rfidSn;
    }

    public void setRfidSn(String rfidSn) {
        this.rfidSn = rfidSn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getGuaranteeDate() {
        return guaranteeDate;
    }

    public void setGuaranteeDate(String guaranteeDate) {
        this.guaranteeDate = guaranteeDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
