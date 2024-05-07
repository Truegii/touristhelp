package com.example.login.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.login.ListaZonas;
import com.example.login.Lugar;
import com.example.login.MainActivity;
import com.example.login.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {


    private FragmentHomeBinding binding;
    RequestQueue requestQueue;
    ArrayList<String> departamentosCosta = new ArrayList<>();
    ArrayList<String> departamentosSierra = new ArrayList<>();
    ArrayList<String> departamentosSelva = new ArrayList<>();
    ArrayList<Lugar> listaLugares = new ArrayList<>();
    ArrayAdapter adpCosta;

    ArrayAdapter adpSierra;

    ArrayAdapter adpSelva;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        llenaDatos();
        requestQueue = Volley.newRequestQueue(getActivity());
        binding.spindepa.setAdapter(adpCosta);
        binding.spinreg.setOnItemSelectedListener(this);
        binding.btnBuscaz.setOnClickListener(this);

        return root;
    }
    public void llenaDatos(){
        departamentosCosta.clear();
        departamentosSierra.clear();
        departamentosSelva.clear();
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
        adpCosta = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, departamentosCosta);
        adpSierra = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, departamentosSierra);
        adpSelva = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, departamentosSelva);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (i==0){
            binding.spindepa.setAdapter(adpCosta);
        } else if (i==1){
            binding.spindepa.setAdapter(adpSierra);
        }else if (i==2){
            binding.spindepa.setAdapter(adpSelva);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        String nomdep = binding.spindepa.getSelectedItem().toString();

        readUser(nomdep);
    }
    private void readUser(String depanom) {

        String URL1 = "http://192.168.1.37/listazonas.php?depaz=" + depanom;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL1,null, new Response.Listener<JSONArray>() {
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

                    Intent intent = new Intent(getActivity(), ListaZonas.class);
                    intent.putExtra("lista", listaLugares);

                    HomeFragment.this.startActivity(intent);


                } catch (JSONException e) {
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity(),volleyError.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(request);

    }
}