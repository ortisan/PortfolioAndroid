package ortiz.com.br.portfolio.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import ortiz.com.br.portfolio.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoInfoDispositivo = (Button) findViewById(R.id.botao_info_dispositivo);
        botaoInfoDispositivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DevicesInfoActivity.class);
                startActivity(intent);
            }
        });

        Button botaoExemploGridView = (Button) findViewById(R.id.botao_exemplo_grid_view);
        botaoExemploGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GridViewExampleActivity.class);
                startActivity(intent);
            }
        });


        Button botaoExemploHorizontalScroll = (Button) findViewById(R.id.botao_exemplo_horizontal_scroll);
        botaoExemploHorizontalScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HorizScrollViewExampleActivity.class);
                startActivity(intent);
            }
        });

        Button botaoRecycle = (Button) findViewById(R.id.botao_exemplo_recycle);
        botaoRecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecicleViewExampleActivity.class);
                startActivity(intent);
            }
        });


    }


}
