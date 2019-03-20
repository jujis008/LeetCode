package com.wilson.leetcode.test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by i324291 on 2018/8/7.
 */
public class Test implements Serializable {
    private volatile boolean flag = false;
    private Test() {
        synchronized(Test.class) {
            if (!flag) {
                flag = !flag;
            } else {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
    }

    private static class TestHolder {
        private static final Test INSTANCE = new Test();
    }

    public static Test getInstance() {
        return TestHolder.INSTANCE;
    }

//    private Object readResolve() {
//        return TestHolder.INSTANCE;
//    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Class<?> clazz = Test.class;
        Constructor<?> ctor = clazz.getDeclaredConstructor(null);
        ctor.setAccessible(true);
        Test t1 = (Test) ctor.newInstance();
        Test t2 = (Test) ctor.newInstance();
        System.out.println(t1 == t2);


        Test t3 = getInstance();
        Test t4 = null;
        try (FileOutputStream fos = new FileOutputStream("test.obj");ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(t3);
            oos.flush();
        } catch (IOException x) {
            x.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("test.obj");ObjectInputStream ois = new ObjectInputStream(fis)){
            t4 = (Test) ois.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(t3 == t4);
    }
}
