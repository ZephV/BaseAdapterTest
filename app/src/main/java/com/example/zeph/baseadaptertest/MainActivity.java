package com.example.zeph.baseadaptertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    List<ItemBeam> itemBeamList = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      itemBeamList.add(new ItemBeam(
          R.mipmap.ic_launcher,
          "我是标题" + i,
          "我是内容" + i
      ));
    }

    ListView listView = (ListView) findViewById(R.id.lv_main);
    BaseAdapter myAdapter = new BaseAdapter(this, itemBeamList);
    listView.setAdapter(myAdapter);

  }
}
