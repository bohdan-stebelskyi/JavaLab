package lab2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        JsonSerializer<Car> jsz = new JsonSerializer<Car>(Car.class);

        Car Car = new Car("red", "toyota", 3245656);

        jsz.serialize(Car, "test.json");

        Car Car1;

        Car1 = jsz.deserialize("test.json");

        System.out.println(Car1.toString());

        XmlSerializer<Car> xsz = new XmlSerializer<Car>(Car.class);

        xsz.serialize(Car, "test.xml");

        TxtSerializer<Car> tsz = new TxtSerializer<Car>();

        tsz.serialize(Car, "test.txt");

        Car Car2;

        Car2 = tsz.deserialize("test.txt");

        System.out.println(Car2.toString());


    }
}