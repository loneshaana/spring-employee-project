package employee.example.data.services.map;

import employee.example.data.model.BaseEntity;
import employee.example.data.model.Result;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity, ID extends Long>{
    protected Map<Long,T> dataMap = new HashMap<>();

    T findById(ID id){
        return dataMap.get(id);
    }

    Result deleteById(ID id){
        if(dataMap.keySet().contains(id)) {
            dataMap.remove(id);
            return new Result(true);
        }
        else {
            return new Result(false);
        }
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
