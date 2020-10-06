package com.example.bus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listBus;
    List<Bus> lista;
    EditText marca,modelo,origemDestino,tipo,totais,ocupados;
    ArrayAdapter<String> adapter;
    BusAdapter adaptation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       marca = findViewById(R.id.marca);
       modelo = findViewById(R.id.modelo);
       origemDestino = findViewById(R.id.origemDestino);
       tipo = findViewById(R.id.tipo);
       totais = findViewById(R.id.assTotais);
       ocupados = findViewById(R.id.assOcupados);

        listBus = findViewById(R.id.listBus);
        lista  = new ArrayList<>();

        listBus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bus bus = (Bus) adapterView.getItemAtPosition(i);
                String info = "modelo de Onibus" +bus.getModelo()+" ";
                info += " tem " + bus.getAssOcupados()+" acssentos ocupados";

                int total = Integer.parseInt(bus.getAssTotais());
                int ocupado = Integer.parseInt(bus.getAssOcupados());
                if(ocupado < total){
                    ocupado +=1;
                    bus.setAssOcupados(String.valueOf(ocupado));
                    adaptation.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, bus.getOrigemDestino(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "este veiculo nao possui acentos disponiveis", Toast.LENGTH_SHORT).show();
                }

               // Toast.makeText(MainActivity.this, bus.getOrigemDestino(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void registra(View view) {
        String marca_str  = marca.getText().toString();
        String modelo_str = modelo.getText().toString();
        String origemDestino_str = origemDestino.getText().toString();
        String tipo_str = tipo.getText().toString();
        String totais_str = totais.getText().toString();
        String ocupados_str = ocupados.getText().toString();

        if(Integer.parseInt(totais_str)<Integer.parseInt(ocupados_str)){
            String info = "limite de assentos comprometido";
            Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
        }else{
            Bus bus = new Bus(marca,modelo,origemDestino,tipo,totais,ocupados);
            lista.add(bus);
            adaptation.notifyDataSetChanged();
            marca.setText("");
            modelo.setText("");
            origemDestino.setText("");
            tipo.setText("");
            totais.setText("");
            ocupados.setText("");
        }
     //   onStart(marca_str,modelo_str,origemDestino_str,tipo_str,totais_str,ocupados_str);

        //lista.add(new Bus(marca_str,modelo_str,origemDestino_str,tipo_str,totais_str,ocupados_str));
    }

    @Override
    protected void onStart(){
        super.onStart();
        lista.add(new Bus("volvo","VOLARE W9 ON","curitiba/bahia","leito","30","29"));
        lista.add(new Bus("volvo","VOLARE W8","curitiba/bahia","leito","30","30"));
        lista.add(new Bus("volvo","NEOBUS THUNDER","bahia/curitiba","comum","30","15"));
        preencherOnibusList();
    }

    private void preencherOnibusList() {
        int layoutId = R.layout.produto_list_item;
        adaptation = new BusAdapter(this,layoutId,lista);

        listBus.setAdapter(adaptation);
    }







}