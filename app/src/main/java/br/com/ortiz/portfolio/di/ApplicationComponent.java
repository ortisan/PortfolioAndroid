package br.com.ortiz.portfolio.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ortiz.com.br.portfolio.activity.BaseActivity;

/**
 * Created by 56789 on 12/08/2015.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);
    Context context();
}
