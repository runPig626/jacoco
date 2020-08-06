package com.oyhp.demo.jacoco.annotation;

import java.lang.annotation.Annotation;

/**
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-08-06
 */
@JDBCConfig(ip = "127.0.0.1", database = "test",
        password = "1234", encoding = "utf-8",
        loginName = "root")
public class DBUtil {
    public static void classForName(String driver){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Annotation[] annotations = DBUtil.class.getAnnotations();
        for (Annotation annotate : annotations) {
            String annotateName = annotate.annotationType().getSimpleName();
            if(annotateName.equals("JDBCConfig")){
                System.out.println("DBUtil.class = " + DBUtil.class);
            }
        }

        DBUtil.classForName("com.mysql.jdbc.Driver");
    }

}
