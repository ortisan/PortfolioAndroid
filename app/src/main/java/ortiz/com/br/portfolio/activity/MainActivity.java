package ortiz.com.br.portfolio.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.ortiz.portfolio.adapter.MyAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import ortiz.com.br.portfolio.R;

public class MainActivity extends AppCompatActivity {

    private String[] titlesRow = {"Buscar", "Compartilhar"};
    private int[] iconsRow = {R.drawable.ic_search, R.drawable.ic_share};

    private ActionBarDrawerToggle mDrawerToggle;

    @Bind(R.id.tool_bar)
    Toolbar mToolbar;
    @Bind(R.id.recycler_lista_menu_drawer)
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_layout);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(new MyAdapter(titlesRow, iconsRow));
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, this.mToolbar, R.string.abrir, R.string.fechar) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(MainActivity.this, "Drawer aberto", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(MainActivity.this, "Drawer fechado", Toast.LENGTH_SHORT).show();
            }
        };

        drawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        Button botaoInfoDispositivo = (Button) findViewById(R.id.botao_info_dispositivo);
        botaoInfoDispositivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DevicesInfoActivity.class);
                startActivity(intent);
            }
        });

        Button botaoExemploGridView = (Button) findViewById(R.id.botao_exemplo_grid_view);
        botaoExemploGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GridViewExampleActivity.class);
                startActivity(intent);
            }
        });

        Button botaoExemploHorizontalScroll = (Button) findViewById(R.id.botao_exemplo_horizontal_scroll);
        botaoExemploHorizontalScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HorizScrollViewExampleActivity.class);
                startActivity(intent);
            }
        });

        Button botaoFrameLayout = (Button) findViewById(R.id.botao_exemplo_frame_layout);
        botaoFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FrameLayoutExampleActivity.class);
                startActivity(intent);
            }
        });

        Button botaoRecycle = (Button) findViewById(R.id.botao_exemplo_recycle);
        botaoRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecicleViewExampleActivity.class);
                startActivity(intent);
            }
        });

        Button botaoCards = (Button) findViewById(R.id.botao_exemplo_cards);
        botaoCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CardsExampleActivity.class);
                startActivity(intent);
            }
        });

        Button botaoCustomVIew = (Button) findViewById(R.id.botao_exemplo_custom_view);
        botaoCustomVIew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomViewExampleActivity.class);
                startActivity(intent);
            }
        });

        Button botaoExemploStore = (Button) findViewById(R.id.botao_exemplo_store);
        botaoExemploStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StoreExampleActivity.class);
                startActivity(intent);
            }
        });

        Button botaoDesignWidgets = (Button) findViewById(R.id.botao_design_widget);
        botaoDesignWidgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DesignWidgetExampleActivity.class);
                startActivity(intent);
            }
        });

        Button botaoDagger = (Button) findViewById(R.id.botao_dagger);
        botaoDagger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DaggerTestsActivity.class);
                startActivity(intent);
            }
        });


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
