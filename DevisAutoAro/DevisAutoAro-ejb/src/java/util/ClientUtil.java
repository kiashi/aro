/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Date;

/**
 *
 * @author Misaina
 */
public class ClientUtil {
    
    /**
     * 10 caractères :
     * 2 : CL
     * @return 
     */
    public static String buildNoClient(){
        Date d = new Date();       
        String res = Util.addPrefix(8, d.getSeconds()+""+d.getMinutes()+""+d.getHours()+""+d.getDay(), "0");
        return "CL"+res;
    }
    
    public static String buildNoProcedure(){
        Date d = new Date();       
        String res = Util.addPrefix(6, d.getSeconds()+""+d.getMinutes()+""+d.getHours()+""+d.getDay(), "0");
        return res;
    }
    
}
