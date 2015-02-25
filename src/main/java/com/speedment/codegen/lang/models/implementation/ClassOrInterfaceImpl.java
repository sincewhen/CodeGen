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
package com.speedment.codegen.lang.models.implementation;

import com.speedment.codegen.lang.models.AnnotationUsage;
import com.speedment.codegen.lang.models.ClassOrInterface;
import com.speedment.codegen.lang.models.Field;
import com.speedment.codegen.lang.models.Generic;
import com.speedment.codegen.lang.models.Javadoc;
import com.speedment.codegen.lang.models.Method;
import com.speedment.codegen.lang.models.Type;
import com.speedment.codegen.lang.models.modifiers.Modifier;
import com.speedment.util.Copier;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author Emil Forslund
 * @param <T>
 */
public abstract class ClassOrInterfaceImpl<T extends ClassOrInterface<T>> 
    implements ClassOrInterface<T> {
	
	private String name;
	private Optional<Javadoc> javadoc;
	private final List<AnnotationUsage> annotations;
	private final List<Generic> generics;
	private final List<Type> interfaces;
	private final List<Field> fields;
	private final List<Method> methods;
	private final List<ClassOrInterface> classes;
	private final Set<Modifier> modifiers;

	public ClassOrInterfaceImpl(String name) {
		this.name			= name;
		this.javadoc		= Optional.empty();
		this.annotations	= new ArrayList<>();
		this.generics		= new ArrayList<>();
		this.interfaces		= new ArrayList<>();
		this.fields			= new ArrayList<>();
		this.methods		= new ArrayList<>();
		this.classes		= new ArrayList<>();
		this.modifiers		= EnumSet.noneOf(Modifier.class);
	}
	
	protected ClassOrInterfaceImpl(ClassOrInterfaceImpl<T> prototype) {
		name			= prototype.name;
		javadoc			= Copier.copy(prototype.javadoc);
		annotations		= Copier.copy(prototype.annotations);
		generics		= Copier.copy(prototype.generics);
		interfaces		= Copier.copy(prototype.interfaces);
		fields			= Copier.copy(prototype.fields);
		methods			= Copier.copy(prototype.methods);
		classes			= Copier.copy(prototype.classes);
		modifiers		= Copier.copy(prototype.modifiers, c -> c.copy(), EnumSet.noneOf(Modifier.class));
	}

	@Override
	public T setName(String name) {
		this.name = name;
		return (T) this;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public T setJavadoc(Javadoc doc) {
		javadoc = Optional.of(doc);
		return (T) this;
	}

	@Override
	public Optional<Javadoc> getJavadoc() {
		return javadoc;
	}

	@Override
	public List<Method> getMethods() {
		return methods;
	}

	@Override
	public List<Field> getFields() {
		return fields;
	}

	@Override
	public List<Type> getInterfaces() {
		return interfaces;
	}
	
	@Override
	public Set<Modifier> getModifiers() {
		return modifiers;
	}

	@Override
	public List<Generic> getGenerics() {
		return generics;
	}

	@Override
	public List<AnnotationUsage> getAnnotations() {
		return annotations;
	}

	@Override
	public List<ClassOrInterface> getClasses() {
		return classes;
	}
}