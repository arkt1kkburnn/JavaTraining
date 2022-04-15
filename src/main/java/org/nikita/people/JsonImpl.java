package org.nikita.people;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonImpl implements json {

    public JsonImpl() {
    }

    private final ObjectMapper mapper = new ObjectMapper();
    {
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    public void jwrite(String path,Object student) {
        try (FileOutputStream fs = new FileOutputStream(path)){
            mapper.writeValue(fs, student);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Campus jread(String path,Campus campus){
        try {
            campus = mapper.readValue(Paths.get(path).toFile(), Campus.class);
            return campus;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }
}
