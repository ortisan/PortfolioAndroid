package ortiz.com.br.portfolio.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ortiz.com.br.portfolio.R;

/**
 * Created by 56789 on 29/07/2015.
 */
public class DesignWidgetExampleActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_design_widgets_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String mensagem = "";
        boolean result = true;

        switch (item.getItemId()) {
            case R.id.action_settings:
                mensagem = "Confguracoes selecionado";
                break;
            case R.id.action_search:
                mensagem = "Buscar selecionado";
                break;
            case R.id.action_share:
                mensagem = "Compartilhar selecionado";
                break;
        }

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        return result;
    }
}
