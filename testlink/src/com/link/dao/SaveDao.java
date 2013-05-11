package com.link.dao;



import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-10
 * Time: 下午3:53
 * To change this template use File | Settings | File Templates.
 */
public class SaveDao {
    HttpServletRequest request =null;
    Map<String,String>  linkMap=new HashMap<String, String>();
    Map<String,String>  sqlMap=new HashMap<String, String>();
    Map<String,String>  valueMap=new HashMap<String, String>();
    public void init(){
        linkMap.put("user_name","user_name");
        linkMap.put("password","password");
        linkMap.put("email","email");


        sqlMap.put("1","user_name");
        sqlMap.put("2","password");
        sqlMap.put("3","email");

        valueMap.put("user_name","");
        valueMap.put("password","");
        valueMap.put("email","");

    }
    public SaveDao(HttpServletRequest request){

      this.request=request;
    }

    public void parseRequest(HttpServletRequest request){
        Map params = request.getParameterMap();
        Iterator i = params.keySet().iterator();

        while ( i.hasNext() )
        {
            String key = (String) i.next();

            String value = ((String[]) params.get( key ))[ 0 ];
            System.out.println("key="+key+"\t"+"value="+value);
        }


    }
    public void saveObj(HttpServletRequest request){

        String sql="insert into wpc_user(user_name,password,email) values(?,?,?)";




    }

    public  Map parserToMap(String s){
        Map map=new HashMap();
        JSONObject json=JSONObject.fromObject(s);
        Iterator keys=json.keys();
        while(keys.hasNext()){
            String key=(String) keys.next();
            String value=json.get(key).toString();
            if(value.startsWith("{")&&value.endsWith("}")){
                map.put(key, parserToMap(value));
            }else{
                map.put(key, value);
            }

        }
        return map;
    }
}
