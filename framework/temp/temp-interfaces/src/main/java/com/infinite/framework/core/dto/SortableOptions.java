package com.infinite.framework.core.dto;

/**
 * Created by hx on 16-6-15.
 */
public class SortableOptions extends AbstractEntity {
    protected String objectid;
    protected String name;
    protected String describtion;
    protected int order;

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getObjectid() {
        return objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    @Override
    public String toString() {
        return "SortableOptions{" +
                "objectid='" + objectid + '\'' +
                ", name='" + name + '\'' +
                ", describtion='" + describtion + '\'' +
                ", order=" + order +
                '}';
    }
}
