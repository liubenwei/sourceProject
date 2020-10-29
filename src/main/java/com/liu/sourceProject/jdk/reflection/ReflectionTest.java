package com.liu.sourceProject.jdk.reflection;

import java.lang.reflect.Field;

public class ReflectionTest {
	public Boolean isDiffentObject(Object oldObject, Object newObject) throws IllegalAccessException {
		Class<?> oldObjectClazz = oldObject.getClass();
		Class<?> newObjectClazz = newObject.getClass();
		if(oldObjectClazz.equals(newObjectClazz)){
			Field[] oldDeclaredFields = oldObjectClazz.getDeclaredFields();
			for(Field field : oldDeclaredFields){
				field.setAccessible(true);
				Object oldValue = field.get(oldObject);
				Object newValue = field.get(newObject);
				if( (oldValue == null && newValue!= null) || (oldValue != null && !oldValue.equals(newValue))){
					return false;
				}
			}

		}else{
			return false;
		}

		return true;
	}
}
