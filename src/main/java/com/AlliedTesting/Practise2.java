package com.AlliedTesting;

import java.io.IOException;
import java.util.ArrayList;

public class Practise2 {


    public static void main(String[] args) throws IOException {

        ArrayList dates = CSVParser.getArrListOfdate("dates/dates.csv");
        //считываем лист  дат для отправки на веб сервис BNM
//        System.out.println(dates);
//        System.out.println(dates.size());

        ArrayList<String> arrayListOfOutputFromBNM = new ArrayList<>() ;
        //создаю массив из строк. В каждую из строк запишится respons from BNM
        for (int i = 0; i <dates.size()-1; i++) {
            arrayListOfOutputFromBNM.add(i,OutputFromBNM.getValcurs(dates.get(i)));
        }

//        for (int i = 0; i <dates.size()-1 ; i++) {
//            System.out.println(i + arrayListOfOutputFromBNM.get(i));
//        }


        System.out.println("errrrrrrrrrrrrrrrrrrrroooooooooooooooooorrrrrrrrrrrrrrrrrr");
        ArrayList<ValCurs> arrayListOfValCurs = new ArrayList<>();
        for (int i = 0; i <dates.size()-1; i++) {
           arrayListOfValCurs.add(i,Deserialization.deserializeValcurs(arrayListOfOutputFromBNM.get(i)));
        }
        // десерериализуем наши строки в объекты ValCurs

        WriteObjectToXlsX.CreateXlsFile();
        for (int i = 0; i <arrayListOfValCurs.size() ; i++) {
            WriteObjectToXlsX.writeValCursToXlsX(arrayListOfValCurs.get(i));
      }// запишем каждый объект ValCurs в xlsx файл (новый sheet с именем даты , и информацией о валютах




    }
}
