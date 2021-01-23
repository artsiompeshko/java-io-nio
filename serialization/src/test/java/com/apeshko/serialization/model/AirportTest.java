package com.apeshko.serialization.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AirportTest extends SerializationTest {
    @Test
    void whenSerializingAndDeserializing() throws IOException, ClassNotFoundException {
        // given
        Airport airport = new Airport("test", 1000, 2000);

        // when
        serialize(airport);
        Airport deserializedAirport = (Airport) deserialize();

        // then
        assertEquals(airport.getName(), deserializedAirport.getName());

        assertEquals(0, deserializedAirport.getLatitude());
        assertEquals(0, deserializedAirport.getLongitude());
    }
}