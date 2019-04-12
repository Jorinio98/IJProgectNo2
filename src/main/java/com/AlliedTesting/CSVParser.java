package com.AlliedTesting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {


    public static ArrayList getArrListOfdate(String csvFile){

        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> dates = new ArrayList();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] date = line.split(cvsSplitBy);

                for (int i = 0; i <date.length ; i++) {
                    dates.add(date[i]);
                }

//                for (int i = 0; i <dates.size() ; i++) {
//                    System.out.println(dates.get(i));
//                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dates;
    }


    }

