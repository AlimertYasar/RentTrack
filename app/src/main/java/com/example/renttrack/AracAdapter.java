package com.example.renttrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.renttrack.database.entity.Arac;

import java.util.List;

public class AracAdapter extends RecyclerView.Adapter<AracAdapter.AracViewHolder> {

    private Context context;
    private List<Arac> aracListesi;
    private OnCarItemClickListener listener;

    public AracAdapter(Context context, List<Arac> aracListesi, OnCarItemClickListener listener) {
        this.context = context;
        this.aracListesi = aracListesi;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AracViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false);
        return new AracViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AracViewHolder holder, int position) {
        Arac arac = aracListesi.get(position);
        holder.bind(arac);
    }

    @Override
    public int getItemCount() {
        return aracListesi.size();
    }

    public void updateCarList(List<Arac> newCarList) {
        this.aracListesi = newCarList;
        notifyDataSetChanged();
    }

    public interface OnCarItemClickListener {
        void onEditClick(Arac arac);

        void onDeleteClick(Arac arac);
    }

    static class AracViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCarBrand, tvCarModel, tvCarPlate;
        private final TextView tvCarStatus, tvCarRenter, tvCarDuration, tvCarElapsedTime; // Yeni eklenenler
        private final Button btnDelete, btnEdit;

        public AracViewHolder(@NonNull View itemView, OnCarItemClickListener listener) {
            super(itemView);
            // View'ları bağla
            tvCarBrand = itemView.findViewById(R.id.tvCarName);
            tvCarModel = itemView.findViewById(R.id.tvCarModel);
            tvCarPlate = itemView.findViewById(R.id.tvCarPlate);
            tvCarStatus = itemView.findViewById(R.id.tvStatus);
            tvCarRenter = itemView.findViewById(R.id.tvRenter);
            tvCarDuration = itemView.findViewById(R.id.tvDuration);
            tvCarElapsedTime = itemView.findViewById(R.id.tvTimeElapsed);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnEdit = itemView.findViewById(R.id.btnEdit);

            // BUTON CLICK LISTENER'LARI EKLEYELİM
            btnEdit.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onEditClick((Arac) itemView.getTag());
                }
            });

            btnDelete.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener != null) {
                    listener.onDeleteClick((Arac) itemView.getTag());
                }
            });
        }

        public void bind(Arac arac) {
            itemView.setTag(arac); // BU SATIR ÇOK ÖNEMLİ!
            tvCarBrand.setText("Marka: " + arac.getMarka());
            tvCarModel.setText("Model: " + arac.getModel());
            tvCarPlate.setText("Plaka: " + arac.getPlaka());
            tvCarStatus.setText("Durum: " + (arac.isDurum() ? "Kiralık" : "Boş"));
            tvCarRenter.setText("Kiralayan: " + (arac.getKiraci() != null ? arac.getKiraci() : "Yok"));
            tvCarDuration.setText("Kiralama Süresi: " + (arac.getSure() != null ? arac.getSure() : "Yok"));
            tvCarElapsedTime.setText("Geçen Süre: " + (arac.getGecenSure() != null ? arac.getGecenSure() : "Yok"));
        }
    }
}