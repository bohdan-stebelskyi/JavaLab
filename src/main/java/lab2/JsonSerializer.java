package lab2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonSerializer<T> implements Serializer<T>{

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Class<T> classType;

    public JsonSerializer(Class<T> classType){
        this.classType = classType;
    }

    @Override
    public void serialize(T entity, String file){
        try{
            objectMapper.writeValue(new File(file), entity);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public T deserialize(String file){
        try{
            return objectMapper.readValue(new File(file), classType);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
