package com.phong.baitaprenluyen_mosangcholistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.phong.adapter.ContactAdapter;
import com.phong.model.Contact;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void fakeData(int n) {
        Random random = new Random();
        for (int i = 0; i < n; i ++)
        {
            String name = "Tên thứ " + i;
            String phone = "098";
            int x = random.nextInt(3);
            if (x == 1){
                phone = "090";
            }
            else if (x == 2){
                phone = "094";
            }
            for (int p = 0; p < 7; p ++){
                phone += random.nextInt(10);
            }
            Contact c = new Contact(name,phone);
            contactAdapter.add(c);
        }
    }

    private void addControls() {
        lvContact = findViewById(R.id.lvContact);
        contactAdapter = new ContactAdapter(MainActivity.this,R.layout.item);
        lvContact.setAdapter(contactAdapter);
        fakeData(1000);
    }
}
