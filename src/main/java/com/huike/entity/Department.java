package com.huike.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.HashMap;

public class Department implements Serializable {
    private Long id;

    private String name;

    private String sn;

    private static final long serialVersionUID = 1L;

    /**
     *
     * @return
     */
    public String toJson(){
        HashMap<Object, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("sn",sn);
        return JSON.toJSONString(map);
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
        this.name = name == null ? null : name.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sn=").append(sn);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}