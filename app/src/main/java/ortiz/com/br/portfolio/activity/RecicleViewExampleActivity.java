package ortiz.com.br.portfolio.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.com.ortiz.portfolio.adapter.AppRecyclerAdapter;
import br.com.ortiz.portfolio.model.App;
import br.com.ortiz.portfolio.view.DividerItemDecoration;
import ortiz.com.br.portfolio.R;

public class RecicleViewExampleActivity extends Activity {

    private ArrayList<App> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicle_view_example);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_lista_apps_destaques);
        recyclerView.setHasFixedSize(true);
        populateApps();

        //LinearLayoutManager layoutManager = new MyLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AppRecyclerAdapter(this, this.apps, R.layout.app_item_vertical));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));

        final RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_lista_apps);
        recyclerView2.setHasFixedSize(true);

        //LinearLayoutManager layoutManager = new MyLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(new AppRecyclerAdapter(this, this.apps, R.layout.app_item_horizontal));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    private void populateApps() {
        this.apps = new ArrayList<App>();
        this.apps.add(new App("Lara", R.drawable.lara));
        this.apps.add(new App("Carros", R.drawable.carro));
        this.apps.add(new App("Invasion", R.drawable.invasion));

        this.apps.add(new App("Lara", R.drawable.lara));
        this.apps.add(new App("Carros", R.drawable.carro));
        this.apps.add(new App("Invasion", R.drawable.invasion));

        this.apps.add(new App("Lara", R.drawable.lara));
        this.apps.add(new App("Carros", R.drawable.carro));
        this.apps.add(new App("Invasion", R.drawable.invasion));
    }


}
