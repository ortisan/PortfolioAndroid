package ortiz.com.br.portfolio.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.com.ortiz.portfolio.model.App;
import br.com.ortiz.portolio.adapter.ListaAppAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import ortiz.com.br.portfolio.R;

/**
 * Created by 56789 on 13/08/2015.
 */
public class ListaAppsActivity extends BaseActivity {

    @Bind(R.id.cardList)
    RecyclerView listaApps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_apps_layouts);
        ButterKnife.bind(this);

        ArrayList<App> apps = (ArrayList<App>) this.getIntent().getSerializableExtra("apps");

        listaApps.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaApps.setLayoutManager(llm);
        listaApps.setAdapter(new ListaAppAdapter(apps));
    }


    public static Intent getCallingIntent(Context context, ArrayList<App> apps) {
        Intent intent = new Intent(context, ListaAppsActivity.class);
        intent.putExtra("apps", apps);
        return intent;
    }
}
