/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and/or its affiliates, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hibernate.validator.cfg.context;

import java.lang.annotation.ElementType;

/**
 * Facet of a constraint mapping creational context which allows to the select the bean type,
 * bean property or method of a type to which the next operations shall apply.
 *
 * @author Kevin Pollet - SERLI - (kevin.pollet@serli.com)
 * @author Gunnar Morling
 */
public interface TypeTargets {

	/**
	 * Creates a new {@code ConstraintsForType} in order to define constraints on a new bean type.
	 *
	 * @param type The bean type.
	 *
	 * @return Returns a new {@code ConstraintsForType} instance.
	 */
	TypeConstraintMappingCreationalContext type(Class<?> type);

	/**
	 * Changes the property for which added constraints apply.
	 * <p>
	 * Until this method is called constraints apply on class level. After calling this method constraints
	 * apply on the specified property with the given access type.
	 * </p>
	 *
	 * @param property The property on which to apply the following constraints (Java Bean notation).
	 * @param type The access type (field/property).
	 *
	 * @return Returns a new {@code ConstraintsForProperty} instance allowing method chaining.
	 */
	PropertyConstraintMappingCreationalContext property(String property,
														ElementType type);

	/**
	 * Changes the method for which added constraints apply.
	 * <p>
	 * Until this method is called constraints apply on class level. After calling this method constraints
	 * apply to the specified method.
	 * </p>
	 *
	 * @param name The method name.
	 * @param parameterTypes The method parameter types.
	 *
	 * @return Returns a new {@code ConstraintsForMethod} instance allowing method chaining.
	 */
	MethodConstraintMappingCreationalContext method(String name, Class<?>... parameterTypes);

}