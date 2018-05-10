package com.example.narupak.recycleview_insignia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvItem;
    CardView cvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvItem = (RecyclerView) findViewById(R.id.rvItem);

        cvItem = (CardView) findViewById(R.id.cvItem);

        //rvItem.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvItem.setLayoutManager(manager);

//        ArrayList<Item> itemList = generatedDummy();
//
//        ItemAdapter adapter = new ItemAdapter(getApplicationContext(),itemList);
//
//        rvItem.setAdapter(adapter);

        getServiceData();


    }

    private void getServiceData() {
        Call<List<ApproveList>> call = HttpManager.getInstance().getService().getApproveListDataList();
        call.enqueue(new Callback<List<ApproveList>>() {
            @Override
            public void onResponse(Call<List<ApproveList>> call, Response<List<ApproveList>> response) {
                if (response.isSuccessful()) {
                    List<ApproveList> approveLists = response.body();
//                    generatedDummy(approveLists);
                    ArrayList<Item> itemList = generatedDummy(approveLists);

                    ItemAdapter adapter = new ItemAdapter(getApplicationContext(), itemList);
                    rvItem.setAdapter(adapter);

                    Log.d("getServiceData", "if ::" + approveLists.size());
                } else {
                    Log.d("getServiceData", "else ::" + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<ApproveList>> call, Throwable t) {
                Log.d("getServiceData", "onFailure ::" + t);
            }
        });
    }

    private ArrayList<Item> generatedDummy(List<ApproveList> approveLists) {
        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Item item = new Item();
            item.id = i;
            item.text = approveLists.get(1).getPs_fname();
            item.img = "https://akibapress.com/wp-content/uploads/2017/07/We_Can-2.png";
            list.add(item);
        }
        return list;
    }

}
