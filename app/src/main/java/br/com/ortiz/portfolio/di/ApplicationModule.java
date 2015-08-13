package br.com.ortiz.portfolio.di;

import android.content.Context;

import javax.inject.Singleton;

import br.com.ortiz.portfolio.PortfolioApplication;
import br.com.ortiz.presentation.navigation.Navigator;
import dagger.Module;
import dagger.Provides;

/**
 * Created by 56789 on 12/08/2015.
 */


@Module
public class ApplicationModule {

    private final PortfolioApplication application;

    public ApplicationModule(PortfolioApplication application) {
        this.application = application;
    }


    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }


    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }


}
