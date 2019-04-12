package com.AlliedTesting;

import com.thoughtworks.xstream.XStream;

public class Deserialization {

    public static ValCurs deserializeValcurs(String output){

        XStream xStream = new XStream();
        xStream.processAnnotations(ValCurs.class);
        xStream.processAnnotations(Valute.class);


        System.out.println("desssetialaize...\n");
        ValCurs currentValCurs = (ValCurs) xStream.fromXML(output);

        System.out.println(currentValCurs);
        return currentValCurs;
    }

}
