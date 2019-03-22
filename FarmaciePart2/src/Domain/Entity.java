package Domain;

import java.util.Objects;
public abstract class Entity {
    private String id;

    public Entity(String id) {
        this.id = id;
    }

    public String toString() {
        return "Entity{id='" + this.id + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Entity entity = (Entity)o;
            return Objects.equals(this.id, entity.id);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public String getId() {
        return this.id;
    }
}
