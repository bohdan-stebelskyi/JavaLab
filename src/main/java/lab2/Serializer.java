package lab2;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Serializer<T> {

    void serialize(T entity, String file);
    T deserialize(String data);

}
