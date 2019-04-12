package com.AlliedTesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OutputFromBNM {

    public static String getValcurs(Object data) throws IOException {

        URL url = new URL("https://bnm.md/en/official_exchange_rates?get_xml=1&date=" + data);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed :  Http error code " +
                    conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        StringBuilder output = new StringBuilder();
        System.out.println("Output from server..\n");
        String tmp;
        while((tmp = br.readLine()) != null){
            output.append(tmp);
        }
           System.out.println(output.toString().trim());
        return output.toString();
    }
}
