package com.example.dailyburn;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import okhttp3.HttpUrl;

/**
 * Created by Rukshar on 2016-12-13.
 */

public class Summary extends AppCompatActivity{

    ListView restsListView;
    private ArrayAdapter<String> listAdapter;
    private ClientDatabase db;
    private ArrayList<String>names;
    private final String NAMESPACE = "http://com.daily.burn.servlets/";
    private final String SOAP_ACTION = "\"http://com.daily.burn.servlets/getResults\"";
    private final String METHOD_NAME = "getResults";
    private final String URL_App = "http://localhost:8080/DailyBurnWeb/ws/foodreq?wsdl";
    public  static final String FOODID = "NAME";
    private AppCompatActivity hold;
    public static ArrayList<HashMap<String, String>> foodNamesmap;

    String TAG = "Repsonse";
    String response = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        hold = this;
        names = new ArrayList<>();
        //foodNamesmap = new ArrayList<HashMap<String, String>>();

    new AsyncCallWS().execute();
    }
    private class AsyncCallWS extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            //sendHeader();
                        try{
            JSONObject jsonObject = getJSONObjectFromURL("http://10.0.2.2:8080/DailyBurnWeb/getFood");
                            Iterator keysToCopyIterator = jsonObject.keys();
                            List<String> keysList = new ArrayList<String>();
                            while(keysToCopyIterator.hasNext()) {
                                String key = (String) keysToCopyIterator.next();
                                keysList.add(key);
                                names.add(jsonObject.get(key).toString());
                                //HashMap hsmp = new HashMap<String, String>();
                                //hsmp.put(jsonObject.get(key).toString(), key);
                                //foodNamesmap.add(hsmp);
                            }

            } catch (IOException e) {
              e.printStackTrace();
            } catch (JSONException e) {
            e.printStackTrace();

            }
            setList();
            return null;
        }
    }


    private void sendHeader(){

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = false;

        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL_App);
        try{
            envelope.setOutputSoapObject(request);

            List<HeaderProperty> headerList = new ArrayList<HeaderProperty>();
            headerList.add(new HeaderProperty("FoodItem", db.getAllFOODITEM().toString()));

            androidHttpTransport.call(SOAP_ACTION, envelope, headerList);

            SoapPrimitive resultString = (SoapPrimitive) envelope.getResponse();


            Boolean status = Boolean.valueOf(resultString.toString());

            Log.i(TAG, "Result : " + resultString );

        }catch (Exception ex) {
            Log.e(TAG, "Exception: " + ex);
            response = "Exception";
        }
    }

    public static JSONObject getJSONObjectFromURL(String urlString) throws IOException, JSONException {

        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000);
        urlConnection.setConnectTimeout(15000);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        char[] buffer = new char[1024];

        String jsonString = new String();

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        jsonString = sb.toString();

        //System.out.println("JSON: " + jsonString);
        Log.d("JSON:", jsonString);

        return new JSONObject(jsonString);
    }

    private void setList() {
        if(names!=null) {
            restsListView = (ListView) findViewById(R.id.namesList);
            listAdapter = new ArrayAdapter<String>(this, R.layout.listrow, names);
            restsListView.setAdapter(listAdapter);

            restsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String restName = (String)restsListView.getItemAtPosition(position);
                    Intent intent = new Intent(hold, Summary2.class);
                    intent.putExtra(FOODID, restName);
                    startActivity(intent);
                }});
        }
    }


}
