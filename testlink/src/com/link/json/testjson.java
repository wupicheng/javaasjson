package com.link.json;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import java.sql.Connection;
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
        String str = "{\"one\":\"won\",\"two\":2,\"three\":false}";
        JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(str);
        Map<String, Object> myMap = (Map<String, Object>) JSONObject.toBean(jsonObject, Map.class);
        System.out.println(myMap);

    }
}
