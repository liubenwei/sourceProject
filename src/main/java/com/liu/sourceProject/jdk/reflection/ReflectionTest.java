package com.liu.sourceProject.jdk.reflection;

public class ReflectionTest {
	public Boolean isDiffentObject(Object oldObject, Object newObject) {
		Class<?> oldObjectClazz = oldObject.getClass();
		Class<?> newObjectClazz = newObject.getClass();
		if(!oldObjectClazz.equals(newObjectClazz)){

		}

		return true;
	}
}
