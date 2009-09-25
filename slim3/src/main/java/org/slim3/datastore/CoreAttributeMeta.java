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
package org.slim3.datastore;

/**
 * A meta data of attribute.
 * 
 * @author higa
 * @param <M>
 *            the model type
 * @param <A>
 *            the attribute type
 * @since 3.0
 * 
 */
public class CoreAttributeMeta<M, A> extends AbstractAttributeMeta<M, A> {

    /**
     * Constructor.
     * 
     * @param modelMeta
     *            the meta data of model
     * @param name
     *            the name
     * @param attributeClass
     *            the attribute class
     */
    public CoreAttributeMeta(ModelMeta<M> modelMeta, String name,
            Class<A> attributeClass) {
        super(modelMeta, name, attributeClass);
    }

    /**
     * Returns the "equal" filter predicate.
     * 
     * @param value
     *            the value
     * @return the "equal" filter predicate
     */
    public EqualCriterion<M, A> equal(A value) {
        if (isEmpty(value)) {
            return null;
        }
        return new EqualCriterion<M, A>(this, value);
    }
}