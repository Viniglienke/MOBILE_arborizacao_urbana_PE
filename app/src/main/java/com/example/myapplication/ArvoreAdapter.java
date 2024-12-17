package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ArvoreAdapter extends RecyclerView.Adapter<ArvoreAdapter.ArvoreViewHolder> {

    private List<Arvore> arvoreList;

    public ArvoreAdapter(List<Arvore> arvoreList) {
        this.arvoreList = arvoreList;
    }

    @Override
    public ArvoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_arvore, parent, false);
        return new ArvoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArvoreViewHolder holder, int position) {
        Arvore arvore = arvoreList.get(position);
        holder.nomeRegistrante.setText(arvore.getNomeRegistrante());
        holder.nomeCientifico.setText(arvore.getNomeCientifico());

        // Formatar a data de plantio antes de exibi-la
        String formattedDate = formatarData(arvore.getDataPlantio());  // Passando o Date diretamente
        holder.dataPlantio.setText(formattedDate);

        holder.estadoSaude.setText(arvore.getEstadoSaude());
        holder.localizacao.setText(arvore.getLocalizacao());
    }

    @Override
    public int getItemCount() {
        return arvoreList.size();
    }

    public static class ArvoreViewHolder extends RecyclerView.ViewHolder {
        TextView nomeRegistrante;
        TextView nomeCientifico;
        TextView dataPlantio;
        TextView estadoSaude;
        TextView localizacao;

        public ArvoreViewHolder(View itemView) {
            super(itemView);
            nomeRegistrante = itemView.findViewById(R.id.nomeRegistrante);
            nomeCientifico = itemView.findViewById(R.id.nomeCientifico);
            dataPlantio = itemView.findViewById(R.id.dataPlantio);
            estadoSaude = itemView.findViewById(R.id.estadoSaude);
            localizacao = itemView.findViewById(R.id.localizacao);
        }
    }

    // Método para formatar a data no formato desejado
    private String formatarData(Date dataOriginal) {
        try {
            // Novo formato da data (Exemplo: "12/12/2024")
            SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            return newFormat.format(dataOriginal);  // Retorna a data formatada
        } catch (Exception e) {
            e.printStackTrace();
            return dataOriginal.toString();  // Se der erro, retorna a data original
        }
    }
}