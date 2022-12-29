package com.example.pensimu_13868;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MenuActivity extends AppCompatActivity {

    Button btnLogOut;
    EditText edtText;
    FloatingActionButton floatingcart;
    RecyclerView recentRecycle, teratasRecycle;
    RecentAdapter recentAdapter;
    TeratasAdapter teratasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //searchbar eror ehehe
        edtText = findViewById(R.id.srcbar);
        edtText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });


        //button
        floatingcart = findViewById(R.id.floatingcart);
        floatingcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCart();
            }
        });

        btnLogOut = findViewById(R.id.LogOut);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signout();
            }
        });

        //isi data recycle
        List<RecentData> recentDataList = new ArrayList<>();
        recentDataList.add(new RecentData("Sound To Remember",
                "Sampookong", "95k", R.drawable.yura));
        recentDataList.add(new RecentData("Kangen Konco",
                "Gelora USM", "95k", R.drawable.kangen));
        recentDataList.add(new RecentData("ASTROFENCIA",
                "SMAN 6 Semarang", "95k", R.drawable.astro));
        recentDataList.add(new RecentData("BODJONG FESTIVAL 2022",
                "SMAN 3 Semarang", "95k", R.drawable.bodjong));

        setRecentRecycle(recentDataList);

        //isi recycle teratas
        List<RecentDuaData> teratasDataList = new ArrayList<>();
        teratasDataList.add(new RecentDuaData("Harmony Ku 2022r",
                "Grand Arkenso SEMARANG", "85k", R.drawable.harmoni));
        teratasDataList.add(new RecentDuaData("KIDUNG ASMORO",
                "PRPP SEMARANG", "95k", R.drawable.kidung));
        teratasDataList.add(new RecentDuaData("MIPAFEST 2.0",
                "Sampookong", "95k", R.drawable.lumino));
        teratasDataList.add(new RecentDuaData("THE GREAT IDEA FEST",
                "PRPP SEMARANG", "95k", R.drawable.tgif));

        setTeratasRecycle(teratasDataList);
    }

    public void addCart() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    public void signout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, LoginActivity.class));
        finish();

    }

    private void setRecentRecycle(List<RecentData> recentDataList){

        recentRecycle = findViewById(R.id.recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.HORIZONTAL, false);
        recentRecycle.setLayoutManager(layoutManager);
        recentAdapter = new RecentAdapter(this, recentDataList);
        recentRecycle.setAdapter(recentAdapter);

    }

    private void setTeratasRecycle(List<RecentDuaData>TeratasDataList){

        teratasRecycle = findViewById(R.id.recycle_dua);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.HORIZONTAL, false);
        teratasRecycle.setLayoutManager(layoutManager);
        teratasAdapter = new TeratasAdapter(this, TeratasDataList);
        teratasRecycle.setAdapter(teratasAdapter);

    }

    //searchbar tapi gagal awokawok
    private void filter(String text) {

        ArrayList<RecentData> filteredList = new ArrayList<>();

        for (RecentData item : recentAdapter.recentDataList ) {
            if(item.getKonserName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        recentAdapter.filterList(filteredList);

    }

}