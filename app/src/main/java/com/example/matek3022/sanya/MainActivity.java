package com.example.matek3022.sanya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.matek3022.sanya.adapter.RVAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list)
    RecyclerView list;

    RVAdapter adapter;

    public static List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        data = new ArrayList<>();
        data.add("Голова");
        data.add("Гоa assлова");
        data.add("Голdsaова");
        data.add("Голd assdd aasdasdова");
        data.add("Голasd s ова");
        data.add("Голd aова");
        data.add("Гоasd asdasd sdas dлова");
        data.add("Голaas aasasdова");
        data.add("Голa dasова");
        data.add("Голddова");
        data.add("asd  sdова");
        data.add("Голова");
        data.add("Гоa assлова");
        data.add("Голdsaова");
        data.add("Голd assdd aasdasdова");
        data.add("Голasd s ова");
        data.add("Голd aова");
        data.add("Гоasd asdasd sdas dлова");
        data.add("Голaas aasasdова");
        data.add("Голa dasова");
        data.add("Голddова");
        data.add("asd  sdова");

        adapter = new RVAdapter(this, data);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
    }
}
