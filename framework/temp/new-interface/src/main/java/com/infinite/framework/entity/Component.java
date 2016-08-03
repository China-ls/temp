package com.infinite.framework.entity;

import com.infinite.framework.core.entity.AbstractEntity;
import com.infinite.framework.core.object.IDocumentable;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * ComponentFN Entity Bean
 *
 * @author hx on 16-7-25.
 * @since 1.0
 */
//@Entity(EntityConst.CollectionName.COMPONENT)
@Embedded
public class Component extends AbstractEntity implements IDocumentable {
    @Property
    private ObjectId id;
    @Property
    private String sensorId;
    @Property
    private String name;
    @Property
    private String type;
    @Property
    private EntityConst.EntityStatus status = EntityConst.EntityStatus.NORMAL;
    @Embedded
    private ArrayList<Action> actions = new ArrayList<Action>(0);

    private HashMap<String, Object> fields = new HashMap<String, Object>(0);

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EntityConst.EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityConst.EntityStatus status) {
        this.status = status;
    }

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Object> fields) {
        this.fields = fields;
    }

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }

    public Component addActions(Action... actions) {
        if (null == actions) {
            return this;
        }
        for (Action action : actions) {
            this.actions.add(action);
        }
        return this;
    }

    public Component addActions(Collection<Action> actions) {
        if (null == actions) {
            return this;
        }
        this.actions.addAll(actions);
        return this;
    }

    public Component put(String key, Object value) {
        if (!key.startsWith(EntityConst.FieldName.ComponentFN.PREFIX)) {
            key = EntityConst.FieldName.ComponentFN.PREFIX + key;
        }
        fields.put(key, value);
        return this;
    }

    public <T> Object get(String key) {
        if (!key.startsWith(EntityConst.FieldName.ComponentFN.PREFIX)) {
            key = EntityConst.FieldName.ComponentFN.PREFIX + key;
        }
        return fields.get(key);
    }

    public Component put(Map<String, Object> values) {
        if (null != values) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public Document toDocument() {
        Document document = new Document()
                .append("_id", id)
                .append(EntityConst.FieldName.ComponentFN.ID, id)
                .append(EntityConst.FieldName.ComponentFN.NAME, name)
                .append(EntityConst.FieldName.ComponentFN.TYPE, type)
                .append(EntityConst.FieldName.ComponentFN.STATUS, status.name());
        document.putAll(fields);
        ArrayList<Document> documents = new ArrayList<Document>(0);
        for (IDocumentable documentable : actions) {
            documents.add(documentable.toDocument());
        }
        document.put(EntityConst.FieldName.ComponentFN.ACTIONS, documents);
        return document;
    }

    public void fromDocument(Document document) {

    }

    @Override
    public String toString() {
        return "Component{" +
                "id='" + id + '\'' +
                ", sensorId='" + sensorId + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", actions=" + actions +
                ", fields=" + fields +
                '}';
    }
}
