package com.link.json;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-19
 * Time: 下午10:13
 * To change this template use File | Settings | File Templates.
 */
public class tesgson {
    public static void main(String[] args) {
        String str = "{\"one\":{\"name\":{\"xx\":\"xx2\"}},\"two\":[{\"t1\":\"aa\"},{\"t1\":\"bb\"}],\"three\":\"false\"}";
        Map map = new HashMap();
        map.put("1", "x1");
        map.put("2", "x2");
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map1.put("3x1", "1x");
        map2.put("3x2", "2x");
        List list = new ArrayList();
        list.add(map1);
        list.add(map2);
        map.put("3", list);

        JsonParser gsonParser = new JsonParser();
       // JsonElement ge = gsonParser.parse(map.toString());
        JsonElement ge = gsonParser.parse(str);

        JsonObject gj = ge.getAsJsonObject();


        System.out.println(gete(gj,"one.name.xx"));

    }

    public static Object gete(JsonObject gj, String membername) {
        JsonObject gjj=null;
        if (membername.indexOf(".") > -1) {
            String member1 = membername.substring(0, membername.indexOf("."));
            String memberx="";
            if(member1.indexOf("[")>-1&&member1.indexOf("]")>-1){
              String[] x=  member1.split("\\[|\\]");
                memberx=  x[0];
               gjj= gj.get(memberx).getAsJsonArray().get(Integer.parseInt(x[1])).getAsJsonObject();

            }else {
               gjj= gj.get(member1).getAsJsonObject();
            }


            String member2 = membername.substring(membername.indexOf(".")+1, membername.length());

            if (member2.indexOf(".") > -1) {
                return gete(gjj, member2);
            } else {
                if(member2.indexOf("[")>-1&&member1.indexOf("]")>-1){
                    String[] xx=  member1.split("\\[|\\]");
                    String memberxx=  xx[0];
                    return  gj.get(memberxx).getAsJsonArray().get(Integer.parseInt(xx[1])).getAsJsonObject();

                }else
                {
                    return gjj.get(member2);
                }

            }
        } else {
            if(membername.indexOf("[")>-1&&membername.indexOf("]")>-1){
                String[] xx=  membername.split("\\[|\\]");
                String memberxx=  xx[0];
                return  gj.get(memberxx).getAsJsonArray().get(Integer.parseInt(xx[1])).getAsJsonObject();

            }else
            {
                return gj.get(membername);
            }

        }


    }
}
