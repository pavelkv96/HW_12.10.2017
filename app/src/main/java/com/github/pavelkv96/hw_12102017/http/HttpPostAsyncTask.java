package com.github.pavelkv96.hw_12102017.http;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Pavel on 19.10.2017.
 */

class HttpPostAsyncTask extends AsyncTask<String, String, Response> {

    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final String DATA_TYPE = "application/json";

    @Override
    protected Response doInBackground(String... params) {
        String url = params[0];
        String body = params[1];
        URL urlAddress = null;
        HttpURLConnection connection = null;
        Response response = new Response();

        try {
            urlAddress = new URL(url);
            connection = (HttpURLConnection) urlAddress.openConnection();
            connection.setRequestMethod(METHOD_POST);
            connection.setRequestProperty("Content-Type", DATA_TYPE);
            connection.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            int code = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder stringBuilder = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            reader.close();
            response.setText(stringBuilder.toString());
            response.setCode(code);
        } catch (Exception e) {
            response.setCode(500);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return response;
    }
}
