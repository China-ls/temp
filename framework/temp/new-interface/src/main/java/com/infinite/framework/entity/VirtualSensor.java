package com.infinite.framework.entity;

import com.infinite.framework.core.entity.AbstractEntity;
import com.infinite.framework.core.object.IDocumentable;
import org.bson.Document;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * VituralSensor Entity Bean
 *
 * @author hx on 16-7-25.
 * @since 1.0
 */
@Entity(EntityConst.CollectionName.VIRTUALSENSOR)
public class VirtualSensor extends AbstractEntity implements IDocumentable {
    @Id
    private String id;
    @Property
    private String applicationId;
    @Property
    private String name;
    @Property
    private String control;
    @Property
    private String data;
    @Property
    private String system;
    @Property
    private EntityConst.EntityStatus status = EntityConst.EntityStatus.NORMAL;
    private HashMap<String, Object> fields = new HashMap<String, Object>(0);
    @Embedded
    private ArrayList<Component> components = new ArrayList<Component>(0);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public EntityConst.EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityConst.EntityStatus status) {
        this.status = status;
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    public void addComponents(Component... components) {
        if (null == components) {
            return;
        }
        for (Component comp : components) {
            this.components.add(comp);
        }
    }

    public void addComponents(Collection<Component> components) {
        if (null == components) {
            return;
        }
        this.components.addAll(components);
    }

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Object> fields) {
        this.fields = fields;
    }

    public VirtualSensor put(String key, Object value) {
        fields.put(key, value);
        return this;
    }

    public <T> Object get(String key) {
        return fields.get(key);
    }

    public VirtualSensor put(Map<String, Object> values) {
        fields.putAll(values);
        return this;
    }

    public Document toDocument() {
        Document document = new Document()
                .append("_id", id)
                .append(EntityConst.FieldName.VirtualSensorFN.ID, id)
                .append(EntityConst.FieldName.VirtualSensorFN.NAME, name)
                .append(EntityConst.FieldName.VirtualSensorFN.CONTROL, control)
                .append(EntityConst.FieldName.VirtualSensorFN.DATA, data)
                .append(EntityConst.FieldName.VirtualSensorFN.SYSTEM, system)
                .append(EntityConst.FieldName.VirtualSensorFN.STATUS, status.name());
        document.putAll(fields);
        ArrayList<Document> documents = new ArrayList<Document>(0);
        for (IDocumentable documentable : components) {
            documents.add(documentable.toDocument());
        }
        document.put(EntityConst.FieldName.VirtualSensorFN.COMPONENTS, documents);
        return document;
    }

    public void fromDocument(Document document) {

    }

    @Override
    public String toString() {
        return "VirtualSensor{" +
                "id='" + id + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", name='" + name + '\'' +
                ", control='" + control + '\'' +
                ", data='" + data + '\'' +
                ", system='" + system + '\'' +
                ", status=" + status +
                ", components=" + components +
                ", fields=" + fields +
                '}';
    }
}
