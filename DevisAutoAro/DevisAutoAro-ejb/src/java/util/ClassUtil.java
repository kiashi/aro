/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author LENOVO
 */
public class ClassUtil {
    public static Class getClassFromString(String classInString){ 
        if(classInString.compareToIgnoreCase("java.lang.String") == 0) {
            return java.lang.String.class;
        } else if(classInString.compareToIgnoreCase("java.lang.Integer") == 0) {
            return java.lang.Integer.class;
        }
        return null;
    }
}
