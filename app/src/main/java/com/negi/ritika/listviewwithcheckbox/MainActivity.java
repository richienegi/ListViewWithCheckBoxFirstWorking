package com.negi.ritika.listviewwithcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String>selecteditems=new ArrayList<>();
    String []items={"QuickBooks","Tally","HR Management","Finance",
            "Basic Computer","Excel","Advance Excel","Payroll","Myob"};
    String []items1={"Digital Marketing",
            "SEO",
            "PPC",
            "PPC",
            "PPC",
            "PPC",
            "PPC",
            "PPC",
            "PPC",
            "Adsense"};
    ListView li,l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        li=(ListView)findViewById(R.id.chechablelist);
        l1=(ListView)findViewById(R.id.chechablelist1);
        li.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        l1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter arr=new ArrayAdapter(this,R.layout.rowlayout,items);
        li.setAdapter(arr);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=((TextView)view).getText().toString();
                if(selecteditems.contains(selectedItem))
                {
                    selecteditems.remove(selectedItem);
                }
                else
                {
                    selecteditems.add(selectedItem);
                }
            }
        });



        ArrayAdapter arr1=new ArrayAdapter(this,R.layout.rowlayout,items1);
        l1.setAdapter(arr1);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=((TextView)view).getText().toString();
                if(selecteditems.contains(selectedItem))
                {
                    selecteditems.remove(selectedItem);
                }
                else
                {
                    selecteditems.add(selectedItem);
                }
            }
        });

    }
    public void showSelectecdItems(View view)
    {
        String items="";
        for(String item:selecteditems)
        {
            items+="-"+item+"\n";
        }
        Toast.makeText(this, "slected items"+items, Toast.LENGTH_SHORT).show();
    }
}
