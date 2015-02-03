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
package com.speedment.codegen.java.views;

import com.speedment.codegen.base.CodeGenerator;
import com.speedment.codegen.base.CodeView;
import com.speedment.codegen.java.models.Method_;
import com.speedment.util.$;
import com.speedment.util.CodeCombiner;
import static com.speedment.codegen.Formatting.*;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Emil Forslund
 */
public class MethodView implements CodeView<Method_> {

	@Override
	public Optional<CharSequence> render(CodeGenerator cg, Method_ model) {
		return Optional.of(new $(
			cg.on(model.getJavadoc()),
			cg.onEach(model.getModifiers()).collect(CodeCombiner.joinIfNotEmpty(SPACE, EMPTY, SPACE)),
			cg.on(model.getType()), SPACE,
			model.getName(), 
			cg.onEach(model.getParams()).collect(
				Collectors.joining(COMMA_SPACE, PS, PE)
			), SPACE, looseBracketsIndent(
				model.getCode().stream().collect(
					Collectors.joining(nl())
				)
			)
		));
	}
	
}