/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.templates;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ramforth
 */
public class ReflectionUtilities {

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
    } catch (IllegalArgumentException iaex) {
      Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, iaex);
      throw new utilities.exceptions.IllegalArgumentException(iaex);
    } catch (IllegalAccessException iaex) {
      Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, iaex);
      throw new utilities.exceptions.IllegalAccessException(iaex);
    }
  }

  public static void setFieldValueOf(Field field, Object target, Object value) {
    try {
      field.set(target, value);
    } catch (IllegalArgumentException iaex) {
      Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, iaex);
      throw new utilities.exceptions.IllegalArgumentException(iaex);
    } catch (IllegalAccessException iaex) {
      Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, iaex);
      throw new utilities.exceptions.IllegalAccessException(iaex);
    }
  }
  
  public static Object invokeMethodOn(Method method, Object target) {
    return invokeMethodWithArgumentsOn(method, target, new Object[0]);
  }
  
  public static Object invokeMethodWithArgumentsOn(Method method, Object target, Object... arguments) {
    try {
      return method.invoke(target, arguments);
    } catch (IllegalAccessException iaex) {
      Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, iaex);
      throw new utilities.exceptions.IllegalAccessException(iaex);
    } catch (IllegalArgumentException iaex) {
      Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, iaex);
      throw new utilities.exceptions.IllegalArgumentException(iaex);
    } catch (InvocationTargetException itex) {
      Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, itex);
      throw new utilities.exceptions.InvocationTargetException(itex);
    } catch (NullPointerException npex) {
      Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, npex);
      throw new utilities.exceptions.NullPointerException(npex);
    } catch (ExceptionInInitializerError eiiex) {
      Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, eiiex);
      throw new utilities.exceptions.ExceptionInInitializerError(eiiex);
    }
  }
  
}