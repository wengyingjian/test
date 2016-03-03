package com.wengyingjian.test.classloader;


import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="mailto:wengyj@59store.com">翁英健</a>
 * @version 1.1 16/3/3
 * @since 1.1
 */
public class ClassLoaderTest {

    private String rootUrl = "classloader_test_path";

    private ClassLoader loader;

    @Before
    public void init() {
        loader = new MyClassLoader(rootUrl);

    }

    @Test
    public void test() throws Exception {
        //加载不在classpath下的bean
        Class clazz = loader.loadClass("com.wengyingjian.test.classloader.TestLoaderBean");
//        加载classpath下的bean
//        Class clazz = loader.loadClass("com.wengyingjian.test.classloader.tmp.TestLoaderBean");

        System.out.println("class loader :\t" + clazz.getClassLoader().getClass().getName());
        System.out.println("super class loader\t:" + clazz.getSuperclass().getClassLoader());
    }


}
