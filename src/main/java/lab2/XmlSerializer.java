package lab2;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class XmlSerializer<T> implements Serializer<T>{

    private final XmlMapper xmlMapper = new XmlMapper();
    private final Class<T> classType;

    public XmlSerializer(Class<T> classType){
        this.classType = classType;
    }

    @Override
    public void serialize(T entity, String file){
        try{
            xmlMapper.writeValue(new File(file), entity);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public T deserialize(String file){
        try{
            return xmlMapper.readValue(new File(file), classType);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
