package com.apeshko.serialization.model;

import java.io.IOException;

public interface Serializator {
    void serialize(Object obj) throws IOException;
    Object deserialize() throws IOException, ClassNotFoundException;
}
