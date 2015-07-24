package ortiz.com.br.portfolio.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import br.com.ortiz.portfolio.adapter.ImageAdapter;
import ortiz.com.br.portfolio.R;

/**
 * Created by marcelo on 12/06/15.
 */
public class HorizScrollViewExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horiz_scroll_view_example2_layout);
        ListView gridView = (ListView) findViewById(R.id.list_apps);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setHorizontalScrollBarEnabled(true);

    }
}
