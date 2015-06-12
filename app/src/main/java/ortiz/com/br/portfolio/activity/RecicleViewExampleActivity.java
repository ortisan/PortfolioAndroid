package ortiz.com.br.portfolio.activity;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import br.com.ortiz.portfolio.adapter.AppRecyclerAdapter;
import br.com.ortiz.portfolio.adapter.ImageAdapter;
import br.com.ortiz.portfolio.model.App;
import ortiz.com.br.portfolio.R;

public class RecicleViewExampleActivity extends Activity {

    private ArrayList<App> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicle_view_example);

        populateApps();
        RecyclerView view = (RecyclerView) findViewById(R.id.recycle);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        view.setLayoutManager(layoutManager);


        view.setAdapter(new AppRecyclerAdapter(this, this.apps));

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
