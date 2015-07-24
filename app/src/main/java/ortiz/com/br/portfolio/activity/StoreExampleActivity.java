package ortiz.com.br.portfolio.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

import br.com.ortiz.portfolio.adapter.AdapterAppsCategory;
import br.com.ortiz.portfolio.view.ExpandableHeightGridView;
import ortiz.com.br.portfolio.R;

/**
 * Created by 56789 on 23/07/2015.
 */
public class StoreExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_example_layout);

        final ScrollView scroll = (ScrollView) findViewById(R.id.scroll_view);

        LinearLayout storeLayout = (LinearLayout) findViewById(R.id.store_layout);
        LayoutInflater inflater = getLayoutInflater();

        final ViewGroup layoutCategory = (ViewGroup) inflater.inflate(R.layout.category_store_layout, storeLayout, false);
        TextView textTitleCategory = (TextView) layoutCategory.findViewById(R.id.category_title);
        textTitleCategory.setText("Destaques");

        ExpandableHeightGridView gridview = (ExpandableHeightGridView) layoutCategory.findViewById(R.id.category_grid);
        gridview.setAdapter(new AdapterAppsCategory(this));
        storeLayout.addView(layoutCategory);
        gridview.setExpanded(true);

        ViewGroup layoutCategory2 = (ViewGroup) inflater.inflate(R.layout.category_store_layout, storeLayout, false);
        TextView textTitleCategory2 = (TextView) layoutCategory2.findViewById(R.id.category_title);
        textTitleCategory2.setText("Mais Baixados");
        ExpandableHeightGridView gridview2 = (ExpandableHeightGridView) layoutCategory2.findViewById(R.id.category_grid);
        gridview2.setAdapter(new AdapterAppsCategory(this));
        storeLayout.addView(layoutCategory2);
        gridview2.setExpanded(true);

        //final ScrollView scroll = (ScrollView) findViewById(R.id.scroll_view);








        /*scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int alpha = layoutCategory.getBackground().getOpacity();
                int alphInc = (int) (100 * scroll.getScrollY() / scroll.getMaxScrollAmount());
                int newAplha = 255 - alpha + alphInc;
                layoutCategory.getBackground().setAlpha(newAplha);
            }
        });*/

    }


    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
