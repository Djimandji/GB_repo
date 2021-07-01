package ru.gb.GB_repo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Tester {

    static void start(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class testClass = Class.forName(className);
        Object testObj = testClass.newInstance();
        boolean beforeSuite = false;
        boolean afterSuite = false;
        HashMap<Method, Integer> beforeAndAfter = new HashMap<>();
        TreeMap<Integer, Method> testsWithPriority = new TreeMap<>();
        Method[] methods = testClass.getDeclaredMethods();
        ArrayList<Method> ALmethods = new ArrayList<>();

        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (!beforeSuite) {
                    try {
                        System.out.println(testClass.getCanonicalName());
                        m.invoke(testObj);
                        beforeSuite = true;
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }

        for (Method m : methods) {
            if (m.getAnnotation(Test.class) != null) {
                ALmethods.add(m);
            }
        }

        ALmethods.sort((Method m1, Method m2) -> m1.getAnnotation(Test.class).priority() - m2.getAnnotation(Test.class).priority());

        for (Method m : ALmethods) {
            try {
                m.invoke(testObj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        for (Method m : methods) {
            if (m.getAnnotation(AfterSuite.class) != null) {
                if (!afterSuite) {
                    try {
                        m.invoke(testObj);
                        afterSuite = true;
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        }
    }
}
