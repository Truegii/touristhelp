package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login1 extends AppCompatActivity implements View.OnClickListener {
    TextView tv_registrar;
    RequestQueue requestQueue;
    TextView tv_usu;
    TextView tv_pass;
    Button btn_iniciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv_registrar = (TextView) findViewById(R.id.tv_registrar);
        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Login1.this, Registro.class);
                Login1.this.startActivity(intentReg);
            }
        });

        requestQueue = Volley.newRequestQueue(this);
        tv_usu = (EditText) findViewById(R.id.tv_usu);
        tv_pass = (EditText) findViewById(R.id.tv_pass);
        btn_iniciar = (Button) findViewById(R.id.btn_iniciar);

        btn_iniciar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        String correo = tv_usu.getText().toString().trim();
        String password = tv_pass.getText().toString().trim();
        readUser(correo, password);

    }

    private void readUser(String cor, String pas) {
        String URL1 = "http://192.168.1.37/login.php?correo=";
        URL1 = URL1 + cor + "&password=" + pas;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL1,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String correo, nomusu;
                        try {
                            correo = response.getString("correo");
                            nomusu = response.getString("nombre");

                            if (correo.equals(cor)) {
                                Toast.makeText(Login1.this, "Inicio exitoso", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login1.this, MainActivity.class);
                                intent.putExtra("name", nomusu);
                                intent.putExtra("correo", correo);
                                Login1.this.startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(Login1.this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }
}