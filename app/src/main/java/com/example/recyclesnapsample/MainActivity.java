package com.example.recyclesnapsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rv.setLayoutManager(linearLayoutManager);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(rv);

        MyRvAdapter myRvAdapter = new MyRvAdapter();
        myRvAdapter.setItemDataArrayList(createItemList());

        rv.setAdapter(myRvAdapter);
    }

    private ArrayList<MyRvAdapter.ItemData> createItemList(){
        ArrayList<MyRvAdapter.ItemData> itemDataArrayList = new ArrayList<>();

        itemDataArrayList.add(new MyRvAdapter.ItemData(
                AppCompatResources.getDrawable(this, R.mipmap.a1_xxxhdpi_7),
                "已完成\n第一劑疫苗",
                "已接種疫苗",
                AppCompatResources.getDrawable(this, R.drawable.button_background_green),
                getColor(R.color.blue)
                )
        );

        itemDataArrayList.add(new MyRvAdapter.ItemData(
                AppCompatResources.getDrawable(this, R.mipmap.a1_xxxhdpi_8),
                "未完成\n第二劑疫苗",
                "未接種疫苗",
                    AppCompatResources.getDrawable(this, R.drawable.button_background_red),
                    getColor(R.color.red)

                )
        );

        itemDataArrayList.add(new MyRvAdapter.ItemData(
                    AppCompatResources.getDrawable(this, R.mipmap.a1_xxxhdpi_8),
                "未完成\n第三劑疫苗",
                "未接種疫苗",
                    AppCompatResources.getDrawable(this, R.drawable.button_background_red),
                    getColor(R.color.red)

                )
        );

        return itemDataArrayList;
    }
}