package com.serialio;

import com.obj.A;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: wpc
 * Date: 13-5-15
 * Time: 下午2:36
 * To change this template use File | Settings | File Templates.
 */
public class testserial {
    public static void main(String[] args) {

        try {
          A  a=new A();
            a.setAge("21");
          a.setName("xx");
          String xx= new String(objectToBytes(a));

         byte[]  bt=  xx.getBytes();

           Object obj= bytesToObject(bt);
            System.out.println(((A)obj).getName());

            System.out.println(xx);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    public static byte[] objectToBytes(Object obj) throws Exception

    {
        // logger.debug("objectToString called ");
        //ByteArrayOutputStream out = new ByteArrayOutputStream();

//        StringWriter   writer=new StringWriter();
//        ObjectOutputStream sOut = new ObjectOutputStream(writer);
//        sOut.writeObject(obj);
//        sOut.flush();
//        byte[] bytes = out.toByteArray();
        // logger.debug(bytes.toString());
       //return byte;
        return null;
    }
    public static Object bytesToObject(byte[] bytes) throws Exception

    {

        // logger.debug("bytesToObject called ");

        // byte转object

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);

        ObjectInputStream sIn = new ObjectInputStream(in);

        return sIn.readObject();



    }

}

