package br.com.ortiz.portfolio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import ortiz.com.br.portfolio.R;

/**
 * Created by 56789 on 23/07/2015.
 */
public class AdapterAppsCategory extends BaseAdapter {

    private Context context;
    private int[] appsImagesRes = {R.drawable.lara, R.drawable.carro, R.drawable.invasion, R.drawable.lara, R.drawable.carro, R.drawable.invasion};
    private String[] appsNomes = {"Lara", "Carros", "Invasion", "Lara", "Carros", "Invasion"};
    private int numItensRandom;

    public AdapterAppsCategory(Context context) {
        this.context = context;
        this.numItensRandom = 5;//randInt(1, 5);
    }

    @Override
    public int getCount() {
        return this.numItensRandom;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View itemCategoryLayout1 = convertView;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            itemCategoryLayout1 = (View) inflater.inflate(R.layout.item_category_store_layout, parent, false);

        }

        ImageButton button = (ImageButton) itemCategoryLayout1.findViewById(R.id.image_item_category);
        button.setImageResource(appsImagesRes[position]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdapterAppsCategory.this.context, "Item selecionado.", Toast.LENGTH_SHORT).show();
            }
        });

        TextView text = (TextView) itemCategoryLayout1.findViewById(R.id.title_item_category);
        text.setText(this.appsNomes[position]);

        return itemCategoryLayout1;
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
