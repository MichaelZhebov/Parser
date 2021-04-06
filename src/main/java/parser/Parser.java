package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> List<T> deserelized(String filePath, Class clazz) {
        List<T> list = null;
        try {
            final String json = Files.readString(Paths.get(filePath));
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            list = MAPPER.readValue(json, typeFactory.constructCollectionType(ArrayList.class, clazz));
        } catch (IOException e) {
            System.out.println("Parsing error: " + e);
        }
        return list;
    }

}
