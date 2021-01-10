package com.apeshko.serialization.model;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class AirplaneTest extends SerializationTest {
    @Test
    void whenSerializingAndDeserializing() throws IOException, ClassNotFoundException {
        // given
        Airplane airplane = new Airplane.Builder()
                .withCapacity(100)
                .withType(AirplaneType.AIRBUS)
                .withWidth(200)
                .withHeight(1000)
                .withDistance(10000)
                .withWeight(100)
                .withLength(1000)
                .withName("Airbus Test")
                .build();

        // when
        serialize(airplane);
        Airplane deserializedAirplane = (Airplane) deserialize();

        // then
        // non numbers should be deserialized
        assertEquals(airplane.getName(), deserializedAirplane.getName());
        assertEquals(airplane.getType(), deserializedAirplane.getType());

        // numbers should not be deserialized
        assertEquals(0, deserializedAirplane.getCapacity());
        assertEquals(0, deserializedAirplane.getWidth());
        assertEquals(0, deserializedAirplane.getHeight());
        assertEquals(0, deserializedAirplane.getDistance());
        assertEquals(0, deserializedAirplane.getWeight());
    }
}