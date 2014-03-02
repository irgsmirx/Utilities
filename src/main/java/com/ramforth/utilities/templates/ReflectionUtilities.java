/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ramforth.utilities.templates;

import com.ramforth.utilities.common.interfaces.IVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ramforth
 */
public class ReflectionUtilities {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtilities.class);

    public static void visitMethodsOf(Class<?> type, IVisitor<Method> visitor) {
        Class<?> currentClass = type;
        for (Method currentMethod : currentClass.getDeclaredMethods()) {
            visitor.visit(currentMethod);
        }

        Class<?> superClass = currentClass.getSuperclass();
        if (superClass != null) {
            visitMethodsOf(superClass, visitor);
        } else if (currentClass.isInterface()) {
            for (Class<?> superInterface : currentClass.getInterfaces()) {
                visitMethodsOf(superInterface, visitor);
            }
        }
    }

    public static void visitFieldsOf(Class<?> type, IVisitor<Field> visitor) {
        Class<?> currentClass = type;
        while (currentClass != null && currentClass != Object.class) {
            for (Field currentField : currentClass.getDeclaredFields()) {
                visitor.visit(currentField);
            }
            currentClass = currentClass.getSuperclass();
        }
    }

    public static Iterable<Field> getAllFieldsOf(Class<?> type) {
        final List<Field> fields = new ArrayList<>();

        visitFieldsOf(type, new IVisitor<Field>() {
            @Override
            public void visit(Field toVisit) {
                fields.add(toVisit);
            }
        });

        return fields;
    }

    public static Iterable<Method> getAllMethodsOf(Class<?> type) {
        final List<Method> methods = new ArrayList<>();

        visitMethodsOf(type, new IVisitor<Method>() {
            @Override
            public void visit(Method toVisit) {
                methods.add(toVisit);
            }
        });

        return methods;
    }

    public static Field findFieldIn(Class<?> type, String name) {
        Field foundField = null;

        Class<?> currentClass = type;
        while (currentClass != null && currentClass != Object.class && foundField == null) {
            for (Field currentField : currentClass.getDeclaredFields()) {
                if (currentField.getName().equals(name)) {
                    foundField = currentField;
                    break;
                }
            }
            currentClass = currentClass.getSuperclass();
        }

        return foundField;
    }

    public static Field findFieldOfTypeIn(Class<?> type, Class<?> fieldType, String name) {
        Field foundField = null;

        Class<?> currentClass = type;
        while (currentClass != null && currentClass != Object.class && foundField == null) {
            for (Field currentField : currentClass.getDeclaredFields()) {
                if (currentField.getName().equals(name) && currentField.getType().equals(fieldType)) {
                    foundField = currentField;
                    break;
                }
            }
            currentClass = currentClass.getSuperclass();
        }

        return foundField;
    }

    public static Iterable<Field> findFieldsOfTypeIn(Class<?> type, Class<?> fieldType) {
        List<Field> foundFields = new ArrayList<>();

        Class<?> currentClass = type;
        while (currentClass != null && currentClass != Object.class) {
            for (Field currentField : currentClass.getDeclaredFields()) {
                if (currentField.getType().equals(fieldType)) {
                    foundFields.add(currentField);
                    break;
                }
            }
            currentClass = currentClass.getSuperclass();
        }

        return foundFields;
    }

    public static Method findMethodIn(Class<?> type, String name) {
        return findMethodWithParametersIn(type, name, new Class[0]);
    }

    public static Method findMethodWithParametersIn(Class<?> type, String name, Class<?>... parameterTypes) {
        Method foundMethod = null;

        Class<?> currentClass = type;
        while (currentClass != null && currentClass != Object.class && foundMethod == null) {
            Method[] methods;
            if (currentClass.isInterface()) {
                methods = currentClass.getMethods();
            } else {
                methods = currentClass.getDeclaredMethods();
            }

            for (Method method : methods) {
                if (name.equals(method.getName()) && Arrays.equals(parameterTypes, method.getParameterTypes())) {
                    foundMethod = method;
                    break;
                }
            }

            currentClass = currentClass.getSuperclass();
        }

        return foundMethod;
    }

    public static Iterable<Method> findMethodsWithNameIn(Class<?> type, String name) {
        List<Method> foundMethods = new ArrayList<>();

        Class<?> currentClass = type;
        while (currentClass != null && currentClass != Object.class) {
            Method[] methods;
            if (currentClass.isInterface()) {
                methods = currentClass.getMethods();
            } else {
                methods = currentClass.getDeclaredMethods();
            }

            for (Method method : methods) {
                if (name.equals(method.getName())) {
                    foundMethods.add(method);
                }
            }

            currentClass = currentClass.getSuperclass();
        }

        return foundMethods;
    }

    public static Iterable<Method> findMethodsWithParametersIn(Class<?> type, Class<?>... parameterTypes) {
        List<Method> foundMethods = new ArrayList<>();

        Class<?> currentClass = type;
        while (currentClass != null && currentClass != Object.class) {
            Method[] methods;
            if (currentClass.isInterface()) {
                methods = currentClass.getMethods();
            } else {
                methods = currentClass.getDeclaredMethods();
            }

            for (Method method : methods) {
                if (Arrays.equals(parameterTypes, method.getParameterTypes())) {
                    foundMethods.add(method);
                }
            }

            currentClass = currentClass.getSuperclass();
        }

        return foundMethods;
    }

    public static Object getFieldValueFrom(Field field, Object target) {
        try {
            return field.get(target);
        }
        catch (IllegalArgumentException iaex) {
            LOGGER.warn("Error", iaex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.IllegalArgumentException(iaex);
        }
        catch (IllegalAccessException iaex) {
            LOGGER.warn("Error", iaex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.IllegalAccessException(iaex);
        }
    }

    public static void setFieldValueOf(Field field, Object target, Object value) {
        try {
            field.set(target, value);
        }
        catch (IllegalArgumentException iaex) {
            LOGGER.warn("Error", iaex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.IllegalArgumentException(iaex);
        }
        catch (IllegalAccessException iaex) {
            LOGGER.warn("Error", iaex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.IllegalAccessException(iaex);
        }
    }

    public static Object invokeMethodOn(Method method, Object target) {
        return invokeMethodWithArgumentsOn(method, target, new Object[0]);
    }

    public static Object invokeMethodWithArgumentsOn(Method method, Object target, Object... arguments) {
        try {
            return method.invoke(target, arguments);
        }
        catch (IllegalAccessException iaex) {
            LOGGER.warn("Error", iaex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.IllegalAccessException(iaex);
        }
        catch (IllegalArgumentException iaex) {
            LOGGER.warn("Error", iaex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.IllegalArgumentException(iaex);
        }
        catch (InvocationTargetException itex) {
            LOGGER.warn("Error", itex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.InvocationTargetException(itex);
        }
        catch (NullPointerException npex) {
            LOGGER.warn("Error", npex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.NullPointerException(npex);
        }
        catch (ExceptionInInitializerError eiiex) {
            LOGGER.warn("Error", eiiex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.ExceptionInInitializerError(eiiex);
        }
    }
}
