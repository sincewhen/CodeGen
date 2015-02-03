/*
 * Copyright 2015 Emil Forslund.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.speedment.codegen.java;

import com.speedment.codegen.base.CodeGenerator;
import com.speedment.codegen.base.DefaultDependencyManager;

/**
 *
 * @author Emil Forslund
 */
public class JavaGenerator extends CodeGenerator {
	public JavaGenerator() {
		super (Java8.class, new DefaultDependencyManager("java.lang."));
	}
}