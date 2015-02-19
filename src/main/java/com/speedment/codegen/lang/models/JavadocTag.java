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
package com.speedment.codegen.lang.models;

import com.speedment.codegen.lang.interfaces.Copyable;
import com.speedment.codegen.lang.interfaces.Nameable;
import com.speedment.util.Copier;
import java.util.Optional;

/**
 *
 * @author Duncan
 */
public class JavadocTag implements Copyable<JavadocTag>, Nameable<JavadocTag> {
	private String name;
	private Optional<String> value;
	private Optional<String> text;
	
	public JavadocTag(String name) {
		this.name  = name;
		this.value = Optional.empty();
		this.text  = Optional.empty();
	}
	
	public JavadocTag(String name, String text) {
		this.name  = name;
		this.value = Optional.empty();
		this.text  = Optional.of(text);
	}
	
	public JavadocTag(String name, String value, String text) {
		this.name  = name;
		this.value = Optional.of(value);
		this.text  = Optional.of(text);
	}
	
	private JavadocTag(JavadocTag prototype) {
		this.name  = prototype.name;
		this.value = Copier.copy(prototype.value, c -> c);
		this.text  = Copier.copy(prototype.text, c -> c);
	}

	public Optional<String> getValue() {
		return value;
	}

	public JavadocTag setValue(String value) {
		this.value = Optional.of(value);
		return this;
	}

	public Optional<String> getText() {
		return text;
	}

	public JavadocTag setText(String text) {
		this.text = Optional.of(text);
		return this;
	}

	@Override
	public JavadocTag setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public JavadocTag copy() {
		return new JavadocTag(this);
	}
	
	public final static class Const extends JavadocTag {
		public Const(String name) {
			super(name);
		}

		public Const(String name, String value) {
			super(name, value);
		}

		public Const(String name, String value, String text) {
			super(name, value, text);
		}
		
		@Override
		public JavadocTag setValue(String value) {
			return copy().setValue(value);
		}
		
		@Override
		public JavadocTag setText(String text) {
			return copy().setText(text);
		}

		@Override
		public JavadocTag setName(String name) {
			return copy().setName(name);
		}
		
		@Override
		public JavadocTag copy() {
			return new JavadocTag(this);
		}
	}
}