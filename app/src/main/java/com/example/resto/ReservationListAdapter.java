package com.example.resto;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReservationListAdapter extends RecyclerView.Adapter<ReservationListAdapter.ViewHolder>{

    private List<ReservationEntity> reservation;
    private Activity context;
    private UserDatabase database;

    public ReservationListAdapter(Activity context ,List<ReservationEntity> reservation) {
        this.reservation = reservation;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReservationListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_row_reservation,parent,false);
        return new ReservationListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationListAdapter.ViewHolder holder, int position) {

        ReservationEntity data = reservation.get(position);
        database = database.getUserDatabase(context);
        holder.date.setText(data.getDate());
        holder.name.setText(data.getUsername());
        holder.tel.setText(data.getPlaces());
    }



    @Override
    public int getItemCount() {
        {
            return reservation.size();
        }
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView name;
        TextView tel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            name = itemView.findViewById(R.id.name);
            tel = itemView.findViewById(R.id.num);
        }
    }
}
