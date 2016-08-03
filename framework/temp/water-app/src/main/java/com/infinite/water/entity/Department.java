package com.infinite.water.entity;

import java.util.List;

public class Department extends BasicEntity {
    private String address;
    private String contact;
    private Object devices;
    private String icon;
    private String id;
    private String name;
    private String telephone;
    private String uuid;

    private List<Department> sub_departments;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Object getDevices() {
        return devices;
    }

    public void setDevices(Object devices) {
        this.devices = devices;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<Department> getSub_departments() {
        return sub_departments;
    }

    public void setSub_departments(List<Department> sub_departments) {
        this.sub_departments = sub_departments;
    }
}
