package ortiz.com.br.portfolio.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import br.com.ortiz.portfolio.adapter.AppRecyclerAdapter;
import br.com.ortiz.portfolio.model.App;
import br.com.ortiz.portfolio.view.DividerItemDecoration;
import ortiz.com.br.portfolio.R;

public class CardsExampleActivity extends ActionBarActivity {

    private ArrayList<App> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards_example_layout);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_lista_cards);
        recyclerView.setHasFixedSize(true);
        populateApps();

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(layoutManager2);
        recyclerView.setAdapter(new AppRecyclerAdapter(this, this.apps, R.layout.item_card));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cards_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
