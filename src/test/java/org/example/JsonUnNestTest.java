package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonUnNestTest {

    @Test
    void etl() {
        String jsonString = "{\n" +
                "    'name': 'John Doe',\n" +
                "    'age': 30,\n" +
                "    'isStudent': false,\n" +
                "    'address': {\n" +
                "        'city': 'Example City',\n" +
                "        'zipcode': '12345'\n" +
                "    },\n" +
                "    'contactInfo': {\n" +
                "        'email': 'john.doe@example.com',\n" +
                "        'phone': '123-456-7890'\n" +
                "    }\n" +
                "}";

//        JsonUnNest.load(JsonUnNest.transform(JsonUnNest.extract(jsonString)));
    }
}