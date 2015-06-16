package ortiz.com.br.portfolio.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;

import java.util.ArrayList;

import br.com.ortiz.portfolio.adapter.AppRecyclerAdapter;
import br.com.ortiz.portfolio.model.App;
import br.com.ortiz.portfolio.view.ItemDecorator;
import ortiz.com.br.portfolio.R;

public class RecicleViewExampleActivity extends Activity {

    private ArrayList<App> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicle_view_example);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        populateApps();

        //LinearLayoutManager layoutManager = new MyLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AppRecyclerAdapter(this, this.apps));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenHeight = metrics.heightPixels;
        int screenWidth = metrics.widthPixels;


        ItemTouchHelper mIth = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT) {
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        final int fromPos = viewHolder.getAdapterPosition();
                        final int toPos = viewHolder.getAdapterPosition();
                        // move item in `fromPos` to `toPos` in adapter.
                        return true;// true if moved, false otherwise
                    }

                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        // remove from adapter
                    }
                });


        mIth.attachToRecyclerView(recyclerView);

        //recyclerView.getDisplay().sMetrics();





        /*
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        final RecyclerView recyclerViewListagem = (RecyclerView) findViewById(R.id.recycle_123);
        recyclerViewListagem.setLayoutManager(layoutManager2);
        recyclerViewListagem.setItemAnimator(new DefaultItemAnimator());*/

//        recyclerView.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                if (event.getAction() == MotionEvent.ACTION_SCROLL) {
//                    int center = recyclerView.getScrollX() + recyclerView.getWidth() / 2;
//
//                    int chilrenNum = recyclerView.getAdapter().getItemCount();
//
//                    for (int i = 0; i < chilrenNum; i++) {
//                        findViewById(recyclerView.getAdapter().getChildAt(i);
//                        int viewLeft = v2.getLeft();
//                        int viewWidth = v2.getWidth();
//                        if (center >= viewLeft && center <= viewLeft + viewWidth) {
//                            recyclerView.scrollBy((viewLeft + viewWidth / 2) - center, 0);
//                            break;
//                        }
//                    }
//                }
//                return false;
//            }
//        });
    }

    private void populateApps() {
        this.apps = new ArrayList<App>();
        this.apps.add(new App("Lara", R.drawable.lara));
        this.apps.add(new App("Carros", R.drawable.carro));
        this.apps.add(new App("Invasion", R.drawable.invasion));

        this.apps.add(new App("Lara", R.drawable.lara));
        this.apps.add(new App("Carros", R.drawable.carro));
        this.apps.add(new App("Invasion", R.drawable.invasion));

        this.apps.add(new App("Lara", R.drawable.lara));
        this.apps.add(new App("Carros", R.drawable.carro));
        this.apps.add(new App("Invasion", R.drawable.invasion));
    }


}
