package com.example.myfirstandroiddevelopingexperience;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class EmailListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        Drawable mDivider = ContextCompat.getDrawable(this, R.drawable.divider);


        DividerItemDecoration vItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        vItemDecoration.setDrawable(mDivider);

        EmailAdapter emailAdapter = new EmailAdapter(this, Email.getAllEmails());
        recyclerView.setAdapter(emailAdapter);

    }
}