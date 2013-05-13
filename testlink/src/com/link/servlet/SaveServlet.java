package com.link.servlet;

import com.link.dao.SaveDao;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-10
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
public class SaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String username=  req.getParameter("user_name");
       // String[] a = req.getParameterValues("user_name");

        Enumeration pn = req.getParameterNames();

        while (pn.hasMoreElements()) {
            String parName = (String) pn.nextElement();
            System.out.println(parName);
        }
//        for (String string : a) {
//            System.out.println(string);
//        }
        SaveDao sd = new SaveDao(req);
        sd.parseRequest(req);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

        String s= req.getQueryString();
        System.out.println("s=="+s);
        System.out.println("//-----------------------------------------------------------------");
       //-----------------------------------------------------------------
        String str = "{\"one\":[{\"name\":\"aa\"},{\"name\":\"bb\"}],\"two\":2,\"three\":false}";

        JSONObject jsonObject = (JSONObject)JSONSerializer.toJSON(username);
        Map<String, Object> myMap = (Map<String, Object>) JSONObject.toBean(jsonObject, Map.class);
        System.out.println(myMap);
       //---------------------------------------------------------------------


        Map map= sd.parserToMap(str);

        //888888
        System.out.println(map);




    }


}
