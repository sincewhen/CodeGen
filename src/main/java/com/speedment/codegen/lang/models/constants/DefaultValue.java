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
package com.speedment.codegen.lang.models.constants;

import com.speedment.codegen.lang.models.Value;
import com.speedment.codegen.lang.models.values.NullValue;
import com.speedment.codegen.lang.models.values.TextValue;

/**
 *
 * @author Emil Forslund
 */
public abstract class DefaultValue {
    private DefaultValue() {}
    
    public final static Value<?>
		NULL         = new NullValue(),
		EMPTY_STRING = string("");
    
    public static final Value<String> string(String text) {
		return new TextValue(text);
	}
}