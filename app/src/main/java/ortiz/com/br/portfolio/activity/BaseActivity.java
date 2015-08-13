package ortiz.com.br.portfolio.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import br.com.ortiz.portfolio.PortfolioApplication;
import br.com.ortiz.presentation.navigation.Navigator;

/**
 * Created by 56789 on 12/08/2015.
 */
public class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((PortfolioApplication) getApplication()).getApplicationComponent().inject(this);
    }
}
