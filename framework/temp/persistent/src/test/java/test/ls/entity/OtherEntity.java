package test.ls.entity;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class OtherEntity {
    @Id
    private ObjectId id;
    private String sign;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "OtherEntity{" +
                "id=" + id +
                ", sign='" + sign + '\'' +
                '}';
    }
}
