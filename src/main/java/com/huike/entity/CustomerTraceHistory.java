package com.huike.entity;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ljy
 */
@Data
public class CustomerTraceHistory implements Serializable {
    private Long id;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date traceTime;

    private String traceDetails;

    private Long traceTypeId;
    private SystemDictionaryItem traceTypes;

    private Integer traceResult;
    private SystemDictionaryItem traceResults;

    private String remark;

    private Long customerId;
    private Customer customer;

    private Long inputUserId;
    private Employee inputUser;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date inputTime;

    private Integer type;
    private SystemDictionaryItem types;

    public String toJson(){
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("traceTime",traceTime);
        map.put("traceDetails",traceDetails);
        map.put("traceTypeId",traceTypeId);
        map.put("traceTypes",traceTypes);
        map.put("traceResult",traceResult);
        map.put("traceResults",traceResults);
        map.put("remark",remark);
        map.put("customerId",customerId);
        map.put("customer",customer);
        map.put("inputUserId",inputUserId);
        map.put("inputUser",inputUser);
        map.put("inputTime",inputTime);
        map.put("type",type);
        map.put("types",types);
        return JSON.toJSONString(map);
    }

    private String customerName;

    private String employeeName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTraceTime() {
        return traceTime;
    }

    public void setTraceTime(Date traceTime) {
        this.traceTime = traceTime;
    }

    public String getTraceDetails() {
        return traceDetails;
    }

    public void setTraceDetails(String traceDetails) {
        this.traceDetails = traceDetails;
    }

    public Long getTraceTypeId() {
        return traceTypeId;
    }

    public void setTraceTypeId(Long traceTypeId) {
        this.traceTypeId = traceTypeId;
    }

    public SystemDictionaryItem getTraceTypes() {
        return traceTypes;
    }

    public void setTraceTypes(SystemDictionaryItem traceTypes) {
        this.traceTypes = traceTypes;
    }

    public Integer getTraceResult() {
        return traceResult;
    }

    public void setTraceResult(Integer traceResult) {
        this.traceResult = traceResult;
    }

    public SystemDictionaryItem getTraceResults() {
        return traceResults;
    }

    public void setTraceResults(SystemDictionaryItem traceResults) {
        this.traceResults = traceResults;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Long getInputUserId() {
        return inputUserId;
    }

    public void setInputUserId(Long inputUserId) {
        this.inputUserId = inputUserId;
    }

    public Employee getInputUser() {
        return inputUser;
    }

    public void setInputUser(Employee inputUser) {
        this.inputUser = inputUser;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public SystemDictionaryItem getTypes() {
        return types;
    }

    public void setTypes(SystemDictionaryItem types) {
        this.types = types;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "CustomerTraceHistory{" +
                "id=" + id +
                ", traceTime=" + traceTime +
                ", traceDetails='" + traceDetails + '\'' +
                ", traceTypeId=" + traceTypeId +
                ", traceTypes=" + traceTypes +
                ", traceResult=" + traceResult +
                ", traceResults=" + traceResults +
                ", remark='" + remark + '\'' +
                ", customerId=" + customerId +
                ", customer=" + customer +
                ", inputUserId=" + inputUserId +
                ", inputUser=" + inputUser +
                ", inputTime=" + inputTime +
                ", type=" + type +
                ", types=" + types +
                ", customerName='" + customerName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                '}';
    }
}