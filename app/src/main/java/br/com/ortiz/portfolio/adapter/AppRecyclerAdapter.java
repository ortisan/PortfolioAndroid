package br.com.ortiz.portfolio.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import br.com.ortiz.portfolio.model.App;
import ortiz.com.br.portfolio.R;

/**
 * Created by marcelo on 12/06/15.
 */
public class AppRecyclerAdapter extends RecyclerView.Adapter<AppViewHolder> {

    private Context context;
    private ArrayList<App> apps;

    public AppRecyclerAdapter(Context context, ArrayList<App> apps) {
        this.context = context;
        this.apps = apps;
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.app_item, viewGroup, false);
        AppViewHolder viewHolder = new AppViewHolder(this.context, view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AppViewHolder imageViewHolder, int i) {
        App app = this.apps.get(i);
        imageViewHolder.getName().setText(app.getNome());

        ImageView imageView = imageViewHolder.getImage();

        imageViewHolder.getImage().setImageResource(app.getImagem());
        //imageView.setMaxHeight(100);
        //imageView.setMaxWidth(100);
    }

    @Override
    public int getItemCount() {
        return this.apps.size();
    }
}
