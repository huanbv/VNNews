package com.example.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaCodec;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ProgressBar progressBar;
    private EditText searchEt;
    private ImageButton filterBtn;
    private RecyclerView sourcesRv;

    private ArrayList<ModelSourceList> sourceLists;
    private  AdapterSourceList adapterSourceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init ui views
        progressBar = findViewById(R.id.progressBar);
        searchEt = findViewById(R.id.searchEt);
        filterBtn = findViewById(R.id.filterBtn);
        sourcesRv = findViewById(R.id.sourcesRv);

        loadSources();

    }

    private void loadSources() {
        // init list
        sourceLists = new ArrayList<>();
        sourceLists.clear();

        progressBar.setVisibility(View.VISIBLE);

        String url = "https://newsapi.org/v2/sources?apiKey=" +Constants.API_KEY;
        // request data
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            // response is got as string

                try {
                    // convert string to JSON object
                    JSONObject jsonObject = new JSONObject(response);
                    // get sources from that object
                    JSONArray jsonArray = jsonObject.getJSONArray("sources");

                    // get all data from that array using loop
                    for (int  i=0; i<jsonArray.length(); i++){
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                        // make sure to use same key and spellings as in response
                        String id = jsonObject1.getString("id");
                        String name = jsonObject1.getString("name");
                        String description = jsonObject1.getString("description");
                        String url = jsonObject1.getString("url");
                        String country = jsonObject1.getString("country");
                        String category = jsonObject1.getString("category");
                        String language = jsonObject1.getString("language");

                        // set data to model
                        ModelSourceList model = new ModelSourceList(
                                ""+id,
                                ""+name,
                                ""+description,
                                ""+url,
                                ""+category,
                                ""+language,
                                ""+ country
                        );
                        // add model to list
                        sourceLists.add(model);

                    }

                    progressBar.setVisibility(View.GONE);
                    //stup adapter
                    adapterSourceList = new AdapterSourceList(MainActivity.this, sourceLists);
                    // set adapter to recycleview
                    sourcesRv.setAdapter(adapterSourceList);
                }
                catch (Exception e){

                    //exception while loading json data
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            // error white requsting response
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this,""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        // add request to queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}