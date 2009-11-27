/*
 * Copyright 2004-2009 the original author or authors.
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
package org.slim3.gen.datastore;

/**
 * Represents {@code ModelRef} type.
 * 
 * @author taedium
 * 
 */
public class ModelRefType extends ReferenceType {

    /**
     * Creates a new {@code ModelRef}.
     * 
     * @param className
     *            the class name
     * @param typeName
     *            the type name
     */
    public ModelRefType(String className, String typeName) {
        super(className, typeName);
    }

    @Override
    public <R, P, TH extends Throwable> R accept(
            DataTypeVisitor<R, P, TH> visitor, P p) throws TH {
        return visitor.visitModelRefType(this, p);
    }
}