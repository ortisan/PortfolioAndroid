package ortiz.com.br.portfolio.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.ortiz.portfolio.model.App;
import ortiz.com.br.portfolio.R;

/**
 * Created by 56789 on 13/08/2015.
 */
public class InicializacaoActivity extends BaseActivity {

    final StringBuilder sb = new StringBuilder();
    final ArrayList<App> apps = new ArrayList<App>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicializacao_layout);

        String url = "http://homolog.deskmedia.mundopositivo.com.br/android/evconfig";
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response.has("apps")) {
                    try {
                        JSONObject appsJsonObject = response.getJSONObject("apps");
                        Iterator<String> itemApps = appsJsonObject.keys();
                        while (itemApps.hasNext()) {
                            String appKey = itemApps.next();
                            JSONObject appJson = appsJsonObject.getJSONObject(appKey);
                            App app = new App();
                            app.setNome(appJson.getString("nome"));
                            app.setImagemStr(appJson.optString("urlThumb"));
                            apps.add(app);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                InicializacaoActivity.this.navigator.navigateToListApps(InicializacaoActivity.this, apps);

            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error = " + error);
            }
        }
        );


        RequestQueue queue = Volley.newRequestQueue(this);
        queue.start();
        queue.add(stringRequest);
    }


    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, InicializacaoActivity.class);
        return intent;
    }
}
