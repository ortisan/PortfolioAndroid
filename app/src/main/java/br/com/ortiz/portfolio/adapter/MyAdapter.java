package br.com.ortiz.portfolio.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ortiz.com.br.portfolio.R;

/**
 * Created by 56789 on 23/07/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    protected String[] mNavTitles;
    protected int[] mNavIcons;

    public MyAdapter(String[] titles, int[] icons) {
        this.mNavTitles = titles;
        this.mNavIcons = icons;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rowDrawerView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main_nav_draw_row, viewGroup, false);

        ViewHolder holder = new ViewHolder(rowDrawerView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (i < 0 || i > mNavTitles.length) {
            i = 0;
        }
        viewHolder.mTextNavTitle.setText(mNavTitles[i]);
        viewHolder.mImageNavIcon.setImageResource(mNavIcons[i]);
    }

    @Override
    public int getItemCount() {
        return this.mNavTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView mTextNavTitle;
        protected ImageView mImageNavIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextNavTitle = (TextView) itemView.findViewById(R.id.text_row);
            mImageNavIcon = (ImageView) itemView.findViewById(R.id.icon_row);
        }
    }
}
