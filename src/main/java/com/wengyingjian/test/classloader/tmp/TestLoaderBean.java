package com.wengyingjian.test.classloader.tmp;

/**
 * @author <a href="mailto:wengyj@59store.com">翁英健</a>
 * @version 1.1 16/3/3
 * @since 1.1
 */
public class TestLoaderBean {

    static {
        System.out.println("testLoader 被加载");
    }

    {
        System.out.println("testLoader 初始化");
    }
}
