package ortiz.com.br.portfolio.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import ortiz.com.br.portfolio.R;

public class DevicesInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_devices_info);

        TextView viewDeviceName = (TextView) findViewById(R.id.text_device_name);
        TextView viewDeviceVersion = (TextView) findViewById(R.id.text_device_version);

        viewDeviceName.setText(Build.MODEL);
        viewDeviceVersion.setText(Integer.toString(Build.VERSION.SDK_INT));


        Button botaoVoltar = (Button) findViewById(R.id.botao_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DevicesInfoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}
