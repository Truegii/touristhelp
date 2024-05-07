package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity implements View.OnClickListener {
    EditText etnombre, etcorreo, etpassword, etedad;
    Button btn_registrar;
    RequestQueue requestQueue;
    private static final String URL1 = "192.168.1.37/registrar.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        requestQueue = Volley.newRequestQueue(this);
        etnombre = (EditText) findViewById(R.id.edit_nombre);
        etcorreo = (EditText) findViewById(R.id.edit_correo);
        etpassword = (EditText) findViewById(R.id.edit_password);
        etedad = (EditText) findViewById(R.id.edit_edad);
        btn_registrar = (Button) findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {



            String name = etnombre.getText().toString().trim();
            String correo = etcorreo.getText().toString().trim();
            String password = etpassword.getText().toString().trim();
            int age = Integer.parseInt(etedad.getText().toString().trim());

            createUser(name,correo,password,age+"");



    }

    private void createUser(final String name, final String email, final String password, final String age){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Toast.makeText(Registro.this, "Correct",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Registro.this,Login1.class);
                        Registro.this.startActivity(intent);
                    }
                },
                new Response.ErrorListener(){
                    public void onErrorResponse(VolleyError error){
                        Toast.makeText(Registro.this,"Error",Toast.LENGTH_SHORT).show();

                    }
                }
        ){
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("correo",email);
                params.put("password",password);
                params.put("age",age);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }


/**
    @Override
    public void onClick(View view) {
        final String name = etnombre.getText().toString();
        final String correo = etcorreo.getText().toString();
        final String password = etpassword.getText().toString();
        final int age = Integer.parseInt(etedad.getText().toString());

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success){
                        Intent intent = new Intent(Registro.this,MainActivity.class);
                        Registro.this.startActivity(intent);

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("Error de registro")
                                .setNegativeButton("Retry",null)
                                .create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
    }
**/
}