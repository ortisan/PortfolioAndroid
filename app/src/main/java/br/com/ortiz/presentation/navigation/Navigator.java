package br.com.ortiz.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.ortiz.portfolio.model.App;
import ortiz.com.br.portfolio.activity.DaggerTestsActivity;
import ortiz.com.br.portfolio.activity.DrawActivity;
import ortiz.com.br.portfolio.activity.InicializacaoActivity;
import ortiz.com.br.portfolio.activity.ListaAppsActivity;

/**
 * Created by 56789 on 12/08/2015.
 */

@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToDaggerExample(Context context) {
        Intent intent = DaggerTestsActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigateToDrawExample(Context context) {
        Intent intent = DrawActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigateToInicializacao(Context context) {
        Intent intent = InicializacaoActivity.getCallingIntent(context);
        context.startActivity(intent);
    }

    public void navigateToListApps(Context context, ArrayList<App> apps) {
        Intent intent = ListaAppsActivity.getCallingIntent(context, apps);
        context.startActivity(intent);
    }
}
