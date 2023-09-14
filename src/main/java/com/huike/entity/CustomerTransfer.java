package com.huike.entity;

import java.io.Serializable;
import java.util.Date;

public class CustomerTransfer implements Serializable {
    private Long id;

    private Long customerId;
    private Customer customer;

    private Long operatorId;
    private Employee operator;

    private Date operateTime;

    private Long oldSellerId;
    private Employee oldSeller;

    private Long newSellerId;
    private Employee newSeller;

    private String reason;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Long getOldSellerId() {
        return oldSellerId;
    }

    public void setOldSellerId(Long oldSellerId) {
        this.oldSellerId = oldSellerId;
    }

    public Employee getOldSeller() {
        return oldSeller;
    }

    public void setOldSeller(Employee oldSeller) {
        this.oldSeller = oldSeller;
    }

    public Long getNewSellerId() {
        return newSellerId;
    }

    public void setNewSellerId(Long newSellerId) {
        this.newSellerId = newSellerId;
    }

    public Employee getNewSeller() {
        return newSeller;
    }

    public void setNewSeller(Employee newSeller) {
        this.newSeller = newSeller;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "CustomerTransfer{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", customer=" + customer +
                ", operatorId=" + operatorId +
                ", operator=" + operator +
                ", operateTime=" + operateTime +
                ", oldSellerId=" + oldSellerId +
                ", oldSeller=" + oldSeller +
                ", newSellerId=" + newSellerId +
                ", newSeller=" + newSeller +
                ", reason='" + reason + '\'' +
                '}';
    }
}