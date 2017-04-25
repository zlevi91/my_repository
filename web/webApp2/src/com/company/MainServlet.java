package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hackeru on 4/20/2017.
 */
public class MainServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("in post");
        InputStream inputStream=request.getInputStream();
        byte[]buffer=new byte[1024];
        int actuallyRead=inputStream.read(buffer);
        String body=new String(buffer,0,actuallyRead);
        System.out.println(body);
        String result="this is response";
        byte[] resultBytes=result.getBytes();
        OutputStream outputStream=response.getOutputStream();
        outputStream.write(resultBytes);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
/*        System.out.println("in get");
        response.getWriter().write("hello!");
        String queryString=request.getQueryString();
        System.out.println(queryString);
        Map<String,String> qs=new HashMap<>();
        if(queryString!=null){
            String[] keyValues=queryString.split("&");
            for (String keyValue : keyValues) {
                String[] keyValuePair=keyValue.split("=");
                if(keyValuePair.length!=2)
                    continue;
                qs.put(keyValuePair[0],keyValuePair[1]);
            }
        }
        System.out.println(qs.get("username"));
        System.out.println(qs.get("password"));*/

        String queryString=request.getQueryString();
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
        String operator= qs.get("operator");
        if(operator==null)
            return;
        String param1String=qs.get("param1");
        String param2String=qs.get("param1");
        if(param1String==null||param2String==null)
            return;
        int param1=0,param2=0;
        try {
            param1= Integer.parseInt(param1String);
            param2= Integer.parseInt(param2String);
        }catch (Exception ex){
            return;
        }
        System.out.println(param1);
        System.out.println(operator);
        System.out.println(calculate(param1,param2,operator,response));
        response.getWriter().write(calculate(param1,param2,operator,response));
    }

    public String calculate (int p1,int p2,String operator,javax.servlet.http.HttpServletResponse response) throws IOException {
        String result = "";
        switch (operator){
            case "plus":
                return result=String.valueOf(p1+p2);
            case "minus":
                return result=String.valueOf(p1-p2);
            case "mult":
                return result=String.valueOf(p1*p2);
            case "div":
                if(p2==0){
                    response.getWriter().write("division by zero error");
                    return null;
                }
                return result=String.valueOf(p1/p2);
        }
        return result;
    }


}
