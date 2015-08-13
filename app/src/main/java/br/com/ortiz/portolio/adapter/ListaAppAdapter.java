package br.com.ortiz.portolio.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.ortiz.portfolio.model.App;
import ortiz.com.br.portfolio.R;

public class ListaAppAdapter extends RecyclerView.Adapter<ListaAppAdapter.AppViewHolder> {

    private List<App> apps;

    public ListaAppAdapter(List<App> apps) {
        this.apps = apps;
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    @Override
    public void onBindViewHolder(AppViewHolder contactViewHolder, int i) {
        App ci = apps.get(i);
        contactViewHolder.vNome.setText(ci.getNome());
        //contactViewHolder.vImagem.setText(ci.surname);
    }

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_app, viewGroup, false);

        return new AppViewHolder(itemView);
    }

    public class AppViewHolder extends RecyclerView.ViewHolder {

        protected TextView vNome;
        protected ImageView vImagem;


        public AppViewHolder(View itemView) {
            super(itemView);
            this.vNome = (TextView) itemView.findViewById(R.id.nome_app);
            this.vImagem = (ImageView) itemView.findViewById(R.id.imagem_app);
        }
    }
}