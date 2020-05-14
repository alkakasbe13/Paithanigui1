package com.example.paithanigui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.paithanigui.adapters.ProductAdapter;
import com.example.paithanigui.models.Example;
import com.example.paithanigui.models.Product;
import com.example.paithanigui.service.RetrofitClient;
import com.example.paithanigui.service.RetrofitInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerview;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<HashMap<String, String>> arrayListNews;
    static String description1;

    // toolbar1 =v.findViewById(R.id.toolbar);
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview = findViewById(R.id.RecyclerView);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerview.setLayoutManager(mLayoutManager);
        // callAPI();

        bt=findViewById(R.id.bttoolbar);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerview.setLayoutManager(linearLayoutManager2);
        //  recyclerView.setLayoutManager(linearLayoutManager2);
        RetrofitInterface retrofitService = RetrofitClient.getClient().create(RetrofitInterface.class);

        Call<Example> call = retrofitService.getProducts();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, retrofit2.Response<Example> response) {
            /*    List<GeneralFood> popularFoods = response.body().getPopularFood();
                recyclerViewHorizontal.setAdapter(new HorizontalAdapter(popularFoods, R.layout.recyclerview_horizontal, MainActivity.this));
*/
                List<Product> regular = response.body().getProduct();
                mRecyclerview.setNestedScrollingEnabled(false);
                mRecyclerview.setAdapter(new ProductAdapter(regular, R.layout.data_content, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
