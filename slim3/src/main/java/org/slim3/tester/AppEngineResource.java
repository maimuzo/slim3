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
package org.slim3.tester;

import org.junit.rules.ExternalResource;
import org.slim3.util.WrapRuntimeException;

/**
 * initialize appengine resource at test class field.
 * you don't need extends {@link AppEngineTestCase}<br>
 *
 * <pre>
 * public class SomeServiceTest{
 *     &#064;Rule
 *     public AppEngineResource resource = new AppEngineResource();
 *
 *     &#064;Test
 *     public void test(){
 *     }
 * }
 * </pre>
 * @author sue445
 * @since 1.0.17
 */
public class AppEngineResource extends ExternalResource{
    /**
     * The tester for appengine local services.
     */
    public AppEngineTester tester = new AppEngineTester();

    /**
     * setup {@link AppEngineTester}
     */
    @Override
    protected void before() throws Throwable {
        tester.setUp();
    }

    /**
     * teardown {@link AppEngineTester}
     */
    @Override
    protected void after() {
        try {
            tester.tearDown();
        } catch (Exception e) {
            throw new WrapRuntimeException(e);
        }
    }
}
