package Repository;

import Domain.Entity;
import java.util.List;

public interface IRepository<T extends Entity> {

        T findById(String var1);

        void upsert(T var1);

        void remove(String var1);

        List<T> getAll();
        }

