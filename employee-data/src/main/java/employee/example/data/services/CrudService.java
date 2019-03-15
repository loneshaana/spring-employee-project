package employee.example.data.services;

import employee.example.data.model.Result;

import java.util.Set;

public interface CrudService<T,ID> {

    T findById(ID id);

    T save(T object);

    Result deleteById(ID id);

    void delete(T object);

    T replaceAtId(ID id ,T object);
}
