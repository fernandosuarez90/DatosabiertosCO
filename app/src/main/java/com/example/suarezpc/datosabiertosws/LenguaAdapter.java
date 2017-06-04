package com.example.suarezpc.datosabiertosws;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.suarezpc.datosabiertosws.models.Lengua;

import java.util.ArrayList;

/**
 * Created by suarezpc on 1/06/17.
 */

public class LenguaAdapter extends RecyclerView.Adapter<LenguaAdapter.ViewHolder> {
    private ArrayList<Lengua> dataset;

    private Context context;

    public LenguaAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lengua, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lengua a = dataset.get(position);

        holder.departamento.setText(a.getDepartamento().toString());
        holder.nombrelengua.setText(a.getNombreDeLengua().toString());
        holder.habitantes.setText(a.getNMeroDeHabitantes().toString());
        holder.hablantes.setText(a.getNMeroDeHablantes().toString());
        holder.vitalidad.setText(a.getVitalidad().toString());
        holder.familia.setText(a.getFamiliaLingStica().toString());









    }

    @Override
    public int getItemCount() {

        return dataset.size();
    }

    public void adicionarListaLengua(ArrayList<Lengua> listalengua) {
        dataset.addAll(listalengua);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView departamento;
        private TextView nombrelengua;
        private TextView habitantes;
        private TextView hablantes;
        private TextView vitalidad;
        private TextView familia;




        public ViewHolder(View itemView) {
            super(itemView);


            departamento = (TextView) itemView.findViewById(R.id.departamento);
            nombrelengua = (TextView) itemView.findViewById(R.id.nombrelengua);
            habitantes =  (TextView) itemView.findViewById(R.id.habitantes);
            hablantes =  (TextView) itemView.findViewById(R.id.hablantes);
            vitalidad =  (TextView) itemView.findViewById(R.id.vitalidad);
            familia =  (TextView) itemView.findViewById(R.id.familia);





        }
    }
}







