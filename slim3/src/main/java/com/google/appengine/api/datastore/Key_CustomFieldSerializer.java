/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.google.appengine.api.datastore;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;

/**
 * Custom field serializer for Key.
 * 
 * @author bufferings
 * @author higa
 * @since 1.0.0.0
 * 
 */
public final class Key_CustomFieldSerializer {

    /**
     * Deserializes the key.
     * 
     * @param streamReader
     *            the stream reader
     * @param instance
     *            the key
     * @throws SerializationException
     *             if an exception occurred when deserializing
     */
    public static void deserialize(SerializationStreamReader streamReader,
            Key instance) throws SerializationException {
    }

    /**
     * Instantiates a key.
     * 
     * @param streamReader
     *            the stream reader
     * @return a key
     * @throws SerializationException
     *             if an exception occurred when instantiating.
     */
    public static Key instantiate(SerializationStreamReader streamReader)
            throws SerializationException {
        String kind = streamReader.readString();
        Key parentKey = (Key) streamReader.readObject();
        long id = streamReader.readLong();
        String name = streamReader.readString();
        AppIdNamespace appIdNamespace =
            (AppIdNamespace) streamReader.readObject();
        return new Key(kind, parentKey, id, name, appIdNamespace);
    }

    /**
     * Serializes the key.
     * 
     * @param streamWriter
     *            the stream writer
     * @param instance
     *            the key
     * @throws SerializationException
     *             if an exception occurred when serializing
     */
    public static void serialize(SerializationStreamWriter streamWriter,
            Key instance) throws SerializationException {
        streamWriter.writeString(instance.getKind());
        streamWriter.writeObject(instance.getParent());
        streamWriter.writeLong(instance.getId());
        streamWriter.writeString(instance.getName());
        streamWriter.writeObject(instance.getAppIdNamespace());
    }
}