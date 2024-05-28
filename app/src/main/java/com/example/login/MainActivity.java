package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SearchView;
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

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Spinner mSpinner,depas;
    RequestQueue requestQueue;
    SearchView searchView;
    ArrayList<Lugar> listaLugares = new ArrayList<>();
    ArrayList<Lugar> listaAll = new ArrayList<>();
    ArrayList<Lugar> listaItems = new ArrayList<>();
    private Button btnBuscaz;
    Button btnCosta,btnSierra,btnSelva;
    ArrayList<String> departamentosCosta = new ArrayList<>();
    ArrayList<String> departamentosSierra = new ArrayList<>();
    ArrayList<String> departamentosSelva = new ArrayList<>();
    ArrayAdapter adpCosta;
    ArrayAdapter adpSierra;
    RecyclerView rvLugares;
    ArrayAdapter adpSelva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "No Disponible", Snackbar.LENGTH_LONG)
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
        TextView textNombreLabel = header.findViewById(R.id.bartexto);



        Intent intent = getIntent();
        String nombre = intent.getStringExtra("name");
        String correo = intent.getStringExtra("correo");
        textTitleLabel.setText(correo);
        textNombreLabel.setText(nombre);

        mSpinner = (Spinner) findViewById(R.id.spinreg);
        depas = (Spinner) findViewById(R.id.spindepa);

        llenaDatos();

        btnCosta = (Button) findViewById(R.id.btn_costa);
        btnSierra = (Button) findViewById(R.id.btn_sierra);
        btnSelva = (Button) findViewById(R.id.btn_selva);

        depas.setAdapter(adpCosta);

        btnBuscaz = (Button) findViewById(R.id.btn_buscaz);
        requestQueue = Volley.newRequestQueue(this);

        mSpinner.setOnItemSelectedListener(this);

        btnBuscaz.setOnClickListener(this);
        btnCosta.setOnClickListener(this);
        btnSierra.setOnClickListener(this);
        btnSelva.setOnClickListener(this);
        listRegiones("listacosta");

        rvLugares = findViewById(R.id.RVZonas2);

        listaTodo();

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
        MenuItem menuItem = menu.findItem(R.id.itembuscar);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filtrado(s);
                rvLugares.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rvLugares.setAdapter(new Adaptador(listaItems, MainActivity.this));
                return false;
            }
        });

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


        if(v.getId() == btnBuscaz.getId()){
            String nomdep = depas.getSelectedItem().toString();
            readUser(nomdep);
        }else if (v.getId() == btnCosta.getId()){
            listRegiones("listacosta");
        }else if (v.getId() == btnSierra.getId()){
            listRegiones("listasierra");
        }else if (v.getId() == btnSelva.getId()){
            listRegiones("listaselva");
        }

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

    private void listRegiones(String region) {

        String URL1 = "http://192.168.1.37/"+region+".php";

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
                        String depa = object.getString("depa");
                        String direccion = object.getString("direc");
                        String calificacion = object.getString("califica");

                        Lugar lugares = new Lugar(id, nombre, descripcion, imagenurl, depa,direccion, calificacion);
                        listaLugares.add(lugares);


                    }



                    rvLugares.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rvLugares.setAdapter(new Adaptador(listaLugares, MainActivity.this));

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

    private void listaTodo() {

        String URL1 = "http://192.168.1.37/buscaitem.php";

        JsonArrayRequest  request = new JsonArrayRequest(Request.Method.GET, URL1,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                listaAll.clear();

                try{


                    for (int i = 0; i < response.length(); i++) {
                        JSONObject object = response.getJSONObject(i);

                        String id = object.getString("id");
                        String nombre = object.getString("nombre");
                        String descripcion = object.getString("desc");
                        String imagenurl = object.getString("imgurl");
                        String depa = object.getString("depa");
                        String direccion = object.getString("direc");
                        String calificacion = object.getString("califica");

                        Lugar lugares = new Lugar(id, nombre, descripcion, imagenurl, depa,direccion, calificacion);
                        listaAll.add(lugares);

                    }


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

                    rvLugares.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rvLugares.setAdapter(new Adaptador(listaLugares, MainActivity.this));

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


    public void filtrado(final String busca){
        int longitud = busca.length();
        if (longitud==0){
            listaItems.clear();
            listaItems.addAll(listaAll);
        }else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N){
                List<Lugar> lugares = listaItems.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(busca.toLowerCase()))
                        .collect(Collectors.toList());
                listaItems.clear();
                listaItems.addAll(lugares);
            } else{
                for (Lugar l: listaAll){
                    if (l.getNombre().toLowerCase().contains(busca.toLowerCase())){
                        listaItems.add(l);
                    }
                }
            }
        }

    }

}