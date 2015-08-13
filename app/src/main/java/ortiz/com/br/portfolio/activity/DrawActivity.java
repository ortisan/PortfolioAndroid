package ortiz.com.br.portfolio.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;

import br.com.ortiz.view.DrawView;

/**
 * Created by 56789 on 12/08/2015.
 */
public class DrawActivity extends BaseActivity {

    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int height = displaymetrics.heightPixels;
        drawView.setMaxWidth(width);
        drawView.setMaxHeight(height);
        setContentView(drawView);
    }

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, DrawActivity.class);
        return intent;

    }
}
