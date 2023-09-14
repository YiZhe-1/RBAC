package com.huike.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class Customer implements Serializable {
    private Long id;

    private String name;

    private Integer age;

    private Integer gender;

    private String tel;

    private String qq;

    private Long jobId;
    private SystemDictionaryItem job;

    private Long sourceId;
    private SystemDictionaryItem source;

    private Long sellerId;
    private Employee seller;

    private Long inputUserId;
    private Employee inputUser;

    private Date inputTime;

    private Integer status;

    private String traceType;

    /**
     * 接收前端传来的分组类型下拉框的值
     */
    private Integer groupType;

    private SystemDictionaryItem systemDictionaryItem;

    public String toJson(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("age",age);
        map.put("gender",gender);
        map.put("tel",tel);
        map.put("qq",qq);
        map.put("jobId",jobId);
        map.put("job",job);
        map.put("sourceId",sourceId);
        map.put("source",source);
        map.put("sellerId",sellerId);
        map.put("seller",seller);
        map.put("inputUserId",inputUserId);
        map.put("inputUser",inputUser);
        map.put("inputTime",inputTime);
        map.put("status",status);
        map.put("traceType",traceType);
        map.put("groupType",groupType);
        return JSON.toJSONString(map);
    }

    private static final long serialVersionUID = 1L;

    public SystemDictionaryItem getSystemDictionaryItem() {
        return systemDictionaryItem;
    }

    public void setSystemDictionaryItem(SystemDictionaryItem systemDictionaryItem) {
        this.systemDictionaryItem = systemDictionaryItem;
    }

    public Employee getInputUser() {
        return inputUser;
    }

    public void setInputUser(Employee inputUser) {
        this.inputUser = inputUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public SystemDictionaryItem getJob() {
        return job;
    }

    public void setJob(SystemDictionaryItem job) {
        this.job = job;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public SystemDictionaryItem getSource() {
        return source;
    }

    public void setSource(SystemDictionaryItem source) {
        this.source = source;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Employee getSeller() {
        return seller;
    }

    public void setSeller(Employee seller) {
        this.seller = seller;
    }

    public Long getInputUserId() {
        return inputUserId;
    }

    public void setInputUserId(Long inputUserId) {
        this.inputUserId = inputUserId;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTraceType() {
        return traceType;
    }

    public void setTraceType(String traceType) {
        this.traceType = traceType;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                ", jobId=" + jobId +
                ", job=" + job +
                ", sourceId=" + sourceId +
                ", source=" + source +
                ", sellerId=" + sellerId +
                ", seller=" + seller +
                ", inputUserId=" + inputUserId +
                ", inputUser=" + inputUser +
                ", inputTime=" + inputTime +
                ", status=" + status +
                ", traceType='" + traceType + '\'' +
                ", groupType=" + groupType +
                ", systemDictionaryItem=" + systemDictionaryItem +
                '}';
    }
}