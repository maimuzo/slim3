/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
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
package org.slim3.gen.generator;

import org.slim3.gen.ClassConstants;
import org.slim3.gen.Constants;
import org.slim3.gen.desc.ControllerDesc;
import org.slim3.gen.printer.Printer;
import org.slim3.gen.util.ClassUtil;

/**
 * Generates source codes of a controller test case java file.
 * 
 * @author taedium
 * @since 3.0
 * 
 */
public class ControllerTestCaseGenerator implements Generator {

    /** the controller description */
    protected final ControllerDesc controllerDesc;

    /**
     * Creates a new {@link ControllerTestCaseGenerator}.
     * 
     * @param controllerDesc
     *            the controller description
     */
    public ControllerTestCaseGenerator(ControllerDesc controllerDesc) {
        this.controllerDesc = controllerDesc;
    }

    @Override
    public void generate(Printer p) {
        p.println("package %s;", controllerDesc.getPackageName());
        p.println();
        p.println("import %s;", ClassConstants.ControllerDatastoreTestCase);
        p.println();
        p.println("public class %s%s extends %s {", controllerDesc
                .getSimpleName(), Constants.TEST_SUFFIX, ClassUtil
                .getSimpleName(ClassConstants.ControllerDatastoreTestCase));
        p.println();
        p.println("    public void testExecute() throws Exception {");
        p.println("        start(\"%s\");", controllerDesc.getPath());
        p.println("        %s controller = getController();", controllerDesc
                .getSimpleName());
        p.println("        assertNotNull(controller);");
        p.println("        assertFalse(isRedirect());");
        p.println("        assertEquals(\"%s\", getNextPath());",
                controllerDesc.getViewName());
        p.println("    }");
        p.println("}");
    }
}
