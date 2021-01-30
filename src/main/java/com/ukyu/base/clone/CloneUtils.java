package com.ukyu.base.clone;

import java.io.*;

/**
 * @author ukyu
 * @date 2020/12/17
 **/
public class CloneUtils {

    @SuppressWarnings("unchecked")
    public static <T extends Serializable>T clone(T obj){
        T cloneObj = null;
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out =
                    new ObjectOutputStream(byteOut);
            out.writeObject(obj);
            out.close();

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            cloneObj = (T)in.readObject();
            in.close();
            byteIn.close();
            byteOut.close();
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}
