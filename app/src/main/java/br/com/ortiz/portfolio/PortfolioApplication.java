package br.com.ortiz.portfolio;

import android.app.Application;

import br.com.ortiz.portfolio.di.ApplicationComponent;
import br.com.ortiz.portfolio.di.ApplicationModule;
import br.com.ortiz.portfolio.di.DaggerApplicationComponent;

/**
 * Created by 56789 on 12/08/2015.
 */
public class PortfolioApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
