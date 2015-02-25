/**
 *
 * Copyright (c) 2006-2015, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.codegen.lang.models.modifiers;

import com.speedment.codegen.lang.interfaces.Modifiable;
import static com.speedment.codegen.lang.models.modifiers.Modifier.*;

/**
 *
 * @author Emil Forslund
 * @param <T>
 */
public interface InterfaceMethodModifier<T extends InterfaceMethodModifier<T>> extends Modifiable<T> {
	default T static_() {
		getModifiers().add(STATIC);
		return (T) this;
	}

	default T default_() {
		getModifiers().add(DEFAULT);
		return (T) this;
	}
}
