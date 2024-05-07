package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Spinner mSpinner,depas;
    RequestQueue requestQueue;
    ArrayList<Lugar> listaLugares = new ArrayList<>();
    private Button btnBuscaz;

    ArrayList<String> departamentosCosta = new ArrayList<>();
    ArrayList<String> departamentosSierra = new ArrayList<>();
    ArrayList<String> departamentosSelva = new ArrayList<>();
    ArrayAdapter adpCosta;
    ArrayAdapter adpSierra;

    ArrayAdapter adpSelva;

    TextView tv_navnombre, tv_navcorreo, tv_navedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        View header = navigationView.getHeaderView(0);
        TextView textTitleLabel = header.findViewById(R.id.barnombre);


        tv_navcorreo = (TextView) findViewById(R.id.tvnombre);
        tv_navnombre = (TextView) findViewById(R.id.tvcorreo);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("name");
        String correo = intent.getStringExtra("correo");
        textTitleLabel.setText(correo);
        tv_navcorreo.setText(nombre);
        tv_navnombre.setText(correo);
        mSpinner = (Spinner) findViewById(R.id.spinreg);
        depas = (Spinner) findViewById(R.id.spindepa);

        llenaDatos();

        depas.setAdapter(adpCosta);

        btnBuscaz = (Button) findViewById(R.id.btn_buscaz);
        requestQueue = Volley.newRequestQueue(this);

        mSpinner.setOnItemSelectedListener(this);

        btnBuscaz.setOnClickListener(this);



    }

    public void llenaDatos(){
        departamentosCosta.add("Lima");
        departamentosCosta.add("Arequipa");
        departamentosCosta.add("Tacna");
        departamentosCosta.add("Lambayeque");
        departamentosCosta.add("Áncash");
        departamentosCosta.add("La Libertad");
        departamentosCosta.add("Piura");
        departamentosCosta.add("Tumbes");
        departamentosCosta.add("Moquegua");
        departamentosCosta.add("Ica");
        departamentosSierra.add("Ayacucho");
        departamentosSierra.add("Junín");
        departamentosSierra.add("Cusco");
        departamentosSierra.add("Apurímac");
        departamentosSierra.add("San Martín");
        departamentosSierra.add("Cajamarca");
        departamentosSierra.add("Huancavelica");
        departamentosSierra.add("Huánuco");
        departamentosSierra.add("Puno");
        departamentosSelva.add("Amazonas");
        departamentosSelva.add("Pasco");
        departamentosSelva.add("Madre de Dios");
        departamentosSelva.add("Loreto");
        departamentosSelva.add("Ucayali");
        adpCosta = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, departamentosCosta);
        adpSierra = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, departamentosSierra);
        adpSelva = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, departamentosSelva);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View v) {
        String nomdep = depas.getSelectedItem().toString();

        readUser(nomdep);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (i==0){
            depas.setAdapter(adpCosta);
        } else if (i==1){
            depas.setAdapter(adpSierra);
        }else if (i==2){
            depas.setAdapter(adpSelva);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void readUser(String depanom) {

        String URL1 = "http://192.168.1.37/listazonas.php?depaz=" + depanom;

        JsonArrayRequest  request = new JsonArrayRequest(Request.Method.GET, URL1,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                listaLugares.clear();

                try{


                        for (int i = 0; i < response.length(); i++) {
                            JSONObject object = response.getJSONObject(i);

                            String id = object.getString("id");
                            String nombre = object.getString("nombre");
                            String descripcion = object.getString("desc");
                            String imagenurl = object.getString("imgurl");
                            String direccion = object.getString("direc");
                            String calificacion = object.getString("califica");

                            Lugar lugares = new Lugar(id, nombre, descripcion, imagenurl, depanom,direccion, calificacion);
                            listaLugares.add(lugares);

                        }

                    Intent intent = new Intent(MainActivity.this, ListaZonas.class);
                    intent.putExtra("lista", listaLugares);

                    MainActivity.this.startActivity(intent);


                } catch (JSONException e) {
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(MainActivity.this,volleyError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(request);

    }
}