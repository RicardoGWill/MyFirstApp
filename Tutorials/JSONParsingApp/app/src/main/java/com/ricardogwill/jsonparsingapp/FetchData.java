package com.ricardogwill.jsonparsingapp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// This class is necessary because fetching data must be done asynchronously, on another thread...not in MainActivity.
// Thus, this class must also extend AsyncTask, and note the <> part afterwards as well.
public class FetchData extends AsyncTask<Void, Void, Void> {

    // Note that instead of "String dataString" here and below, a "StringBuffer" could have been used,
    // but that was not explained in the tutorial.
    String dataString;
    String singleParsedString = "";
    String dataParsedString = "";

    @Override
    // Done only in and to the background thread.
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/16c60c");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String lineString = "";
            while (lineString != null) {
                lineString = bufferedReader.readLine();
                dataString = dataString + lineString;
            }

            JSONArray jsonArray = new JSONArray(dataString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                // Note that a Custom ListView would be a BETTER choice than the below simpler option.
                singleParsedString =    "Name: " + jsonObject.get("name") + "\n" +
                                        "Telephone Number: " + jsonObject.get("tel") + "\n" +
                                        "City: " + jsonObject.get("city") + "\n" +
                                        "Country: " + jsonObject.get("country") + "\n";

                dataParsedString = dataParsedString + singleParsedString + "\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    // Can change something in the UI (MainActivity) thread.
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.jsonTextView.setText(this.dataParsedString);
    }
}
