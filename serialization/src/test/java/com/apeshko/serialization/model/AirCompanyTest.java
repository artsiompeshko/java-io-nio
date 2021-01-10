package com.apeshko.serialization.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirCompanyTest extends SerializationTest {
    @Test
    void whenSerializingAndDeserializing() throws IOException, ClassNotFoundException {
        // given
        List<FlyingMachine> flyingMachines = Arrays.asList(new Airplane.Builder()
                .withCapacity(100)
                .withType(AirplaneType.AIRBUS)
                .withWidth(200)
                .withHeight(1000)
                .withDistance(10000)
                .withWeight(100)
                .withLength(1000)
                .withName("Airbus Test")
                .build()
        );

        AirCompany airCompany = new AirCompany("test", flyingMachines);

        // when
        serialize(airCompany);
        AirCompany desirializedAircompany = (AirCompany) deserialize();

        // then
        assertEquals(airCompany.getName(), desirializedAircompany.getName());
        assertEquals(airCompany.getFlyingMachines().size(), desirializedAircompany.getFlyingMachines().size());

        assertEquals(0, desirializedAircompany.getFlyingMachines().get(0).getCapacity());
    }
}