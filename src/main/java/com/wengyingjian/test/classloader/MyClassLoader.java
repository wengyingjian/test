package com.wengyingjian.test.classloader;

import java.io.*;

/**
 * @author <a href="mailto:wengyj@59store.com">翁英健</a>
 * @version 1.1 16/3/3
 * @since 1.1
 */
public class MyClassLoader extends ClassLoader {

    private String rootDir;

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {

        File file = new File(name);
        try {
            FileInputStream fileInputStream = new FileInputStream(classNameToPath(name));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf, 0, len);
            }

            byte[] byteAll = byteArrayOutputStream.toByteArray();
            return defineClass(name, byteAll, 0, byteAll.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

}

