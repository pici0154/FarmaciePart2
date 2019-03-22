package Repository;

import Domain.Entity;
import  Domain.IValidator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity> implements IRepository<T> {
    private Map<String, T> storage = new HashMap();
    private IValidator<T> validator;

    public InMemoryRepository(IValidator<T> validator) {
        this.validator = validator;
    }

    public T findById(String id) {
        //return (Entity)this.storage.get(id);
        return (T)this.storage.get(id);
    }

    public void upsert(T entity) {
        this.validator.validate(entity);
        this.storage.put(entity.getId(), entity);
    }

    public void remove(String id) {
        if (!this.storage.containsKey(id)) {
            throw new RuntimeException("There is no entity with the given id to remove.");
        } else {
            this.storage.remove(id);
        }
    }

    public List<T> getAll() {
        return new ArrayList(this.storage.values());
    }
}
