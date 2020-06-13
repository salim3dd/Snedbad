package com.salim3dd.sendbad;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ReplaceFont.replaceDefaultFont(this,"DEFAULT","font.ttf");

        ListView listView = findViewById(R.id.listView);
        TextView textView = findViewById(R.id.textViewTitle);

        String[] itme = getResources().getStringArray(R.array.index);


        Typeface typeface = Typeface.createFromAsset(getAssets(),"font.otf");
        textView.setTypeface(typeface);


        LayoutInflater lin = getLayoutInflater();
        View appear= lin.inflate(R.layout.row_itme,(ViewGroup)findViewById(R.id.lintmmm));
        TextView txtitm = appear.findViewById(R.id.textitme);
        txtitm.setTypeface(typeface);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,R.layout.row_itme,R.id.textitme,itme);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Webhtml.class);
                intent.putExtra("page",position);
                startActivity(intent);

            }
        });

    }

    public void img_share(View view) {
        String txtshare ="تطبيق حكايات السندباد";
        String sharelink = "https://play.google.com/store/apps/details?id=com.salim3dd.snedad";

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtshare +"\n" + sharelink);
        startActivity(share);

    }

    public void img_morapp(View view) {
        Intent morapp = new Intent(Intent.ACTION_VIEW);
        morapp.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Qays3DD"));
        startActivity(morapp);

    }

    public void img_email(View view) {
        try {
            String txt = "السلام عليكم ورحمة الله وبركاته \n إقتراحي هو :";
            Intent sendemail = new Intent(Intent.ACTION_SEND);
            sendemail.setData(Uri.parse("mailto:"));
            sendemail.setType("message/rfc822");
            sendemail.putExtra(Intent.EXTRA_EMAIL, "salim3ddoman@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT, "تطبيق حكايات السندباد");
            sendemail.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(sendemail);

        }catch (Exception e){Toast.makeText(this,"عذرا لا يوجد تطبيق بريد",Toast.LENGTH_LONG).show(); }

    }

    public void img_close(View view) {finish();}
}
