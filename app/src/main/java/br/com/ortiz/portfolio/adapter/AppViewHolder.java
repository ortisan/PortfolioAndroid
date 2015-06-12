package br.com.ortiz.portfolio.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ortiz.com.br.portfolio.R;

/**
 * Created by marcelo on 12/06/15.
 */
public class AppViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private Context context;
    private TextView name;
    private ImageView image;


    public AppViewHolder(Context context, View itemView) {
        super(itemView);
        this.context = context;
        this.name = (TextView) itemView.findViewById(R.id.name_item);
        this.image = (ImageView) itemView.findViewById(R.id.image_item);

    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }


    @Override
    public void onClick(View view) {
        Toast.makeText(this.context, name.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
