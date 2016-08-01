package com.infinite.framework.entity;

import com.infinite.framework.core.entity.AbstractEntity;
import com.infinite.framework.core.object.IDocumentable;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.HashMap;
import java.util.Map;

/**
 * ActionFN Entity Bean
 *
 * @author hx on 16-7-25.
 * @since 1.0
 */
@Entity(EntityConst.CollectionName.ACTION)
public class Action extends AbstractEntity implements IDocumentable {
    @Id
    private ObjectId id;
    @Property
    private String componentId;
    @Property
    private String name;
    @Property
    private EntityConst.EntityStatus status = EntityConst.EntityStatus.NORMAL;
    @Property
    private HashMap<String, EntityConst.FieldType> arguments = new HashMap<String, EntityConst.FieldType>(0);

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityConst.EntityStatus getStatus() {
        return status;
    }

    public void setStatus(EntityConst.EntityStatus status) {
        this.status = status;
    }

    public HashMap<String, EntityConst.FieldType> getArguments() {
        return arguments;
    }

    public void setArguments(HashMap<String, EntityConst.FieldType> arguments) {
        this.arguments = arguments;
    }

    public Action put(String key, EntityConst.FieldType type) {
        arguments.put(key, type);
        return this;
    }

    public Document toDocument() {
        Document document = new Document()
                .append(EntityConst.FieldName.ActionFN.NAME, name)
                .append(EntityConst.FieldName.ActionFN.STATUS, status.name());
        HashMap<String, String> argumentMap = new HashMap<String, String>(arguments.size());
        for (Map.Entry<String, EntityConst.FieldType> entry : arguments.entrySet()) {
            argumentMap.put(entry.getKey(), entry.getValue().name());
        }
        Document argumentDocument = new Document();
        argumentDocument.putAll(argumentMap);
        document.put(EntityConst.FieldName.ActionFN.ARGUMENTS, argumentDocument);
        return document;
    }

    public void fromDocument(Document document) {

    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", componentId='" + componentId + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", arguments=" + arguments +
                '}';
    }
}
