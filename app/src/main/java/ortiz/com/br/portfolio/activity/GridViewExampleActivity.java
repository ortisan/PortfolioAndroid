package ortiz.com.br.portfolio.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import br.com.ortiz.portfolio.adapter.ImageAdapter;
import ortiz.com.br.portfolio.R;

public class GridViewExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_example_layout);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(this));
    }
}
