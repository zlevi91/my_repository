package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hackeru on 4/23/2017.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {
    String currentMsg=null;
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String queryString=java.net.URLDecoder.decode(request.getQueryString(),"UTF-8");
        System.out.println(queryString);
        Map<String,String> qs=new HashMap<>();
        if(queryString!=null){
            String[] keyValues=queryString.split("&");
            for (String keyValue:keyValues) {
                String[] keyValuePair=keyValue.split("=");
                if(keyValuePair.length!=2)
                    continue;
                qs.put(keyValuePair[0],keyValuePair[1]);
            }
        }
        String act=qs.get("action");
        if(act==null)
            return;
        int action=0;
        try{
            action= Integer.parseInt(act);
        }catch (Exception e){

        }
        switch (action){
            case 1:currentMsg=qs.get("msg");
                break;
            case 2:response.getWriter().write(currentMsg);
                break;
        }

    }
}
