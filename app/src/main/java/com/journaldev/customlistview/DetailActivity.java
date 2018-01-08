package com.journaldev.customlistview;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String string = getIntent().getStringExtra("contact");
        DataModel dataModel = new Gson().fromJson(string, DataModel.class);
        ((TextView) findViewById(R.id.detailname)).setText(dataModel.getName());
        ((TextView) findViewById(R.id.detailnumber)).setText(dataModel.getVersion_number());
        Picasso.with(this).load(dataModel.getImgurl()).resize(600, 600).into(((ImageView) findViewById(R.id.detailimage)));
    }

}
