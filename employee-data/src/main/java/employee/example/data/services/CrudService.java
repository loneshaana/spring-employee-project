package employee.example.data.services;

import java.util.Set;

public interface CrudService<T,ID> {
    public Set<T> getAll();

    T findById(ID id);

    T save(T object);

    void deleteById(ID id);

    void delete(T object);

    T replaceAtId(ID id ,T object);
}
