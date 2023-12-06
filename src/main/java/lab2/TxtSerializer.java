package lab2;

import java.io.*;

public class TxtSerializer<T> implements Serializer<T>{

    @Override
    public void serialize(T entity, String file){

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(entity);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public T deserialize(String file) {

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            return (T) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
