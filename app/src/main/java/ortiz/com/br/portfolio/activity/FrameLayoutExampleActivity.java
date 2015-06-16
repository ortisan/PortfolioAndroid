package ortiz.com.br.portfolio.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import br.com.ortiz.portfolio.model.App;
import ortiz.com.br.portfolio.R;

public class FrameLayoutExampleActivity extends ActionBarActivity {

    private List<App> apps;
    private int idxSelected = 0;
    private ImageView image;
    private ImageButton botaoEsquerda;
    private ImageButton botaoDireita;
    private float xTranslation = 0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_example);
        this.image = (ImageView) findViewById(R.id.image_frame_layout);
        this.botaoEsquerda = (ImageButton) findViewById(R.id.botao_esquerda_frame_layout);
        this.botaoDireita = (ImageButton) findViewById(R.id.botao_direita_frame_layout);

        populateApps();

        botaoEsquerda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idxSelected--;
                xTranslation  = -200f;
                image.setImageResource(apps.get(idxSelected).getImagem());
                esconderBotoes();
                //selecionarImagem();
                selecionarImagemTranslation();
            }
        });

        botaoDireita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idxSelected++;
                xTranslation  = 200f;
                esconderBotoes();
                //selecionarImagem();
                selecionarImagemTranslation();


            }
        });

        esconderBotoes();
        //selecionarImagem();
        selecionarImagemTranslation();
    }

    private void esconderBotoes() {
        if (idxSelected <= 0) {
            this.botaoEsquerda.setVisibility(View.INVISIBLE);
        } else {
            this.botaoEsquerda.setVisibility(View.VISIBLE);
        }
        if (this.idxSelected >= this.apps.size() - 1) {
            this.botaoDireita.setVisibility(View.INVISIBLE);
        } else {
            this.botaoDireita.setVisibility(View.VISIBLE);
        }
    }


    private void selecionarImagem() {
        int fadeInDuration = 500;
        int timeBetween = 3000;
        int fadeOutDuration = 1000;

        this.image.setVisibility(View.INVISIBLE);
        this.image.setImageResource(this.apps.get(idxSelected).getImagem());

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); // add this
        fadeIn.setDuration(fadeInDuration);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); // and this
        fadeOut.setStartOffset(fadeInDuration + timeBetween);
        fadeOut.setDuration(fadeOutDuration);

        AnimationSet animation = new AnimationSet(false); // change to false
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        animation.setRepeatCount(1);
        image.setAnimation(animation);
    }

    private void selecionarImagemTranslation() {
        image.setImageResource(this.apps.get(idxSelected).getImagem());
        TranslateAnimation anim = new TranslateAnimation(xTranslation, 0f, 0.0f, 0.0f);
        anim.setDuration(500);
        anim.setFillAfter(true);
        image.startAnimation(anim);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_frame_layout_example, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
