package ortiz.com.br.portfolio.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import br.com.ortiz.portfolio.model.DaggerVehicleComponent;
import br.com.ortiz.portfolio.model.Vehicle;
import br.com.ortiz.portfolio.model.VehicleComponent;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ortiz.com.br.portfolio.R;

/**
 * Created by 56789 on 12/08/2015.
 */
public class DaggerTestsActivity extends Activity {

    Vehicle vehicle;

    @Bind(R.id.velocidade)
    TextView txtVelocidade;
    @Bind(R.id.bt_acelerar)
    Button btAcelerar;
    @Bind(R.id.bt_frear)
    Button btFrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dagger_tests);

        ButterKnife.bind(this);

        VehicleComponent component = DaggerVehicleComponent.create();
        this.vehicle = component.provideVehicle();


    }

    @OnClick(R.id.bt_acelerar)
    void acelerar() {
        vehicle.increaseSpeed(1);
        this.txtVelocidade.setText("" + vehicle.getSpeed());
    }

    @OnClick(R.id.bt_frear)
    void frear() {
        vehicle.stop();
        this.txtVelocidade.setText("" + vehicle.getSpeed());
    }

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, DaggerTestsActivity.class);
        return intent;

    }


}
