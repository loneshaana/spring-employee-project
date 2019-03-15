package employee.example.data.services.map;

import employee.example.data.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity, ID extends Long>{
    protected Map<Long,T> dataMap = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(dataMap.values());
    }

    T findById(ID id){
        return dataMap.get(id);
    }

    void deleteById(ID id){
         dataMap.remove(id);
    }

    void delete(T object){
        dataMap.remove(object.getId());
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(autoGenerateId());
            }
            dataMap.put(object.getId() , object);
        }else{
            throw new Error("object is required");
        }
        return object;
    }

    T replaceAtId(Long id , T object){
        object.setId(id);
        return dataMap.put(id,object);
    }

    private Long autoGenerateId(){
        Long nextId = null;
        try{
            nextId = Collections.max(dataMap.keySet()) +1;
            Random random = new Random();
            nextId =  ((random.nextLong() * random.nextInt(91) ) / (random.nextInt(91)+1) ) << nextId;
            if(nextId <0) nextId = -1 * nextId;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}
