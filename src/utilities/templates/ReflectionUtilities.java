/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
        final List<Field> fields = new ArrayList<Field>();
        
        visitFieldsOf(type, new IVisitor<Field>() {

            public void visit(Field toVisit) {
                fields.add(toVisit);
            }
        
        });
        
        return fields;
    }
    
    public static Iterable<Method> getAllMethodsOf(Class<?> type) {
        final List<Method> methods = new ArrayList<Method>();
        
        visitMethodsOf(type, new IVisitor<Method>() {

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
        List<Field> foundFields = new ArrayList<Field>();
        
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
    
    public static Method findMethodIn(Class<?> type), String name) {
        
    }
   
    public static Method findMethodWithParametersIn(Class<?> type), String name, Class<?>... parameterTypes) {
        
    }

    public static Iterable<Method> findMethodsWithParametersIn(Class<?> type), Class<?>... parameterTypes) {
        
    }
  
    public static Object getFieldValueFrom(Field field, Object target) {
        try {
            return field.get(target);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
    public static void setFieldValueOf(Field field, Object target, Object value) {
        try {
            field.set(target, value);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReflectionUtilities.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
}
