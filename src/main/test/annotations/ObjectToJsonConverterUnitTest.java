package main.test.annotations;

import com.core.annotations.JsonSerializationException;
import com.core.annotations.ObjectToJsonConverter;
import com.core.annotations.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjectToJsonConverterUnitTest {
    @Test
    public void givenObjectNotSerializedThenExceptionThrown() throws JsonSerializationException {
        Object object = new Object();
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        assertThrows(JsonSerializationException.class, () -> {
            serializer.convertToJson(object);
        });
    }

    @Test
    public void givenObjectSerializedThenTrueReturned() throws JsonSerializationException {
        User person = new User("soufiane", "cheouati");
        ObjectToJsonConverter serializer = new ObjectToJsonConverter();
        String jsonString = serializer.convertToJson(person);
        assertEquals("{\"firstName\":\"Soufiane\",\"lastName\":\"Cheouati\"}", jsonString);
    }
}
