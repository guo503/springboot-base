package com.tsyj;

import org.xml.sax.InputSource;

import java.io.InputStream;

/**
 * @author: guos
 * @date: 2019/9/5$ 12:04$
 **/
public class Test {
    public static void main(String[] args) {
        InputStream is = Test.class
                .getClassLoader()
                .getResourceAsStream(
                        "org/mybatis/generator/config/xml/mybatis-generator-config_1_0.dtd"); //$NON-NLS-1$
        InputSource ins = new InputSource(is);
    }
}
