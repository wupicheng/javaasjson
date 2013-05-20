package com.link.json;

import com.link.dao.SaveDao;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-10
 * Time: 下午7:39
 * To change this template use File | Settings | File Templates.
 */
public class testjson {
    public static void main(String args[]) {
        String str = "{\"one\":{\"name\":{\"xx\":\"xx2\"}},\"two\":[{\"t1\":\"aa\"},{\"t1\":\"bb\"}],\"three\":\"false\"}";
        Map map = SaveDao.parserToMap(str);
        System.out.println(map);
        // System.out.println(map.keySet());
        //System.out.println(map.entrySet().);
        JSONObject json = JSONObject.fromObject(map);
        JSONObject json2=JSONObject.fromObject(str);
//        System.out.println(JSONObject.fromObject(json.get("one")).get("name"));
//        //System.out.println(json);
//         String aa="1.2.3";
//        System.out.println(aa.substring(0,aa.indexOf(".") + 1));
//        System.out.println(aa.split(".").toString());
//
//        System.out.println("2".split(".")[0]);
        //String[]  str1="1.2.3".split(".");
        String aa = "one.name.xx";
       // System.out.println(getj(json, "one.name.xx").get("xx"));
        //System.out.println(getj(json,"two"));
        //System.out.println(aa.substring(aa.lastIndexOf(".") + 1));
        //System.out.println(gets(json, aa));
        System.out.println(json2.getJSONObject("two"));

    }

    public static Object gets(JSONObject jsonObject, String str) {
        return getj(jsonObject, str).get(str.substring(str.lastIndexOf(".") + 1));
    }

    public static JSONObject getj(JSONObject jsonObject, String str) {
        if (str.indexOf(".") > -1) {
            String[] strs = str.split("\\.");
            String str1 = str.substring(str.indexOf(".") + 1);
            // System.out.println("str1====="+str1);
            //System.out.println("str[0]====="+strs[1]);
            JSONObject jsonObject1 = null;
            String sub = strs[0];
            if (strs[0].indexOf("[") > -1 && strs[0].indexOf("]") > -1) {
                sub = strs[0].split("\\[")[0];

            }
            return getj(JSONObject.fromObject(jsonObject.get(strs[0])), str1);

        } else {
            return JSONObject.fromObject(jsonObject.get(str));
        }

    }
}
