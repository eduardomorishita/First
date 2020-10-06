package com.example.bus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BusAdapter extends ArrayAdapter<Bus> {

    int rId;

    public BusAdapter( Context context, int resource,  List<Bus> objects) {
        super(context, resource, objects);
        rId = resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mView = convertView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Bus bus = getItem(position);

        TextView marca = mView.findViewById(R.id.marca);
        TextView modelo = mView.findViewById(R.id.modelo);
        TextView origemDestino = mView.findViewById(R.id.origemDestino);
        TextView tipo = mView.findViewById(R.id.tipo);
        TextView ocupados = mView.findViewById(R.id.assOcupados);
        TextView totais = mView.findViewById(R.id.assTotais);


        marca.setText(bus.getMarca());
        modelo.setText(bus.getModelo());
        origemDestino.setText(bus.getOrigemDestino());
        tipo.setText(bus.getTipo());
        ocupados.setText(String.valueOf(bus.getAssOcupados()));
        totais.setText(String.valueOf(bus.getAssTotais()));

        int ocupado = Integer.parseInt(bus.getAssOcupados());
        int total   = Integer.parseInt(bus.getAssTotais());


        if(ocupado == total){
            totais.setTextColor(getContext().getResources().getColor(R.color.indisponivel));
        }else{
            totais.setTextColor(getContext().getResources().getColor(R.color.disponivel));
        }

        return mView;


    }
}
