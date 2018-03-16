package android.ss.com.bikebasestation.activity;

import android.content.Context;
import android.os.Bundle;
import android.ss.com.bikebasestation.R;
import android.ss.com.bikebasestation.adapter.BikeStationAdapter;
import android.ss.com.bikebasestation.model.ItemBikeStation;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BikeListActivity extends AppCompatActivity {

    public static List<ItemBikeStation> bikeStationList;
    RecyclerView recyclerview;
    private String TAG = BikeListActivity.class.getSimpleName();
    private Context context = BikeListActivity.this;
    private Toolbar toolbar;
    private BikeStationAdapter bikeStationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_list);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.bike_station);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(context));
        bikeStationList = new ArrayList<>();
        String json = null;
        try {
            InputStream is = getAssets().open("dublin.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            Type listType = new TypeToken<ArrayList<ItemBikeStation>>() {
            }.getType();
            bikeStationList = new Gson().fromJson(jsonArray.toString(), listType);

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        bikeStationAdapter = new BikeStationAdapter(bikeStationList);
        recyclerview.setAdapter(bikeStationAdapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
