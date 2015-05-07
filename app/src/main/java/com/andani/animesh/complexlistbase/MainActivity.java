package com.andani.animesh.complexlistbase;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new Andani((this)));
    }
}
class singlerow
{
    String title,desc;
    int img;
    singlerow(String title,String desc,int img)
    {
        this.title=title;
        this.desc=desc;
        this.img=img;
    }

}
class Andani extends BaseAdapter
{
    ArrayList<singlerow> arrayList;Context c;
    Andani(Context c)
    {
        arrayList=new ArrayList<singlerow>();
        this.c=c;
        Resources v=c.getResources();
        String []title=v.getStringArray(R.array.title);
        String []desc=v.getStringArray(R.array.description);
        int img[]={R.drawable.pi1,R.drawable.pi3,R.drawable.pi4,R.drawable.pi6,R.drawable.pi9,R.drawable.pi10,R.drawable.pi7,R.drawable.dango_nyan05,R.drawable.download};

        for(int i=0;i<9;i++)
        {
            arrayList.add(new singlerow(title[i],desc[i],img[i]));
        }




    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row,parent,false);
        ImageView imageView=(ImageView)row.findViewById(R.id.imageView);
        TextView t1=(TextView)row.findViewById(R.id.textView);
        TextView t2=(TextView)row.findViewById(R.id.textView2);
        singlerow singlerow=arrayList.get(position);
        imageView.setImageResource(singlerow.img);
        t1.setText(singlerow.title);
        t2.setText(singlerow.desc);
        return row;
    }
}



