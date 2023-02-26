package com.douglas.thecarserviceapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    Activity activity;
    ArrayList<String> arrayList;

    public MainAdapter(Activity activity, ArrayList<String> arrayList1){
        this.activity = activity;
        arrayList = arrayList1;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_drawer_main, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //set text on textView
        holder.textView.setText(arrayList.get(position));

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();

                switch(position){
                    case 0:
                        activity.startActivity(new Intent(activity, BookAnAppointment.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 1:
                        activity.startActivity(new Intent(activity, SearchServiceProvider.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 2:
                        activity.startActivity(new Intent(activity, ViewAppointments.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 3:
                        activity.startActivity(new Intent(activity, ServiceHistory.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 4:
                        activity.startActivity(new Intent(activity, Profile.class)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case 5:
                        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                        builder.setTitle("logout");
                        builder.setMessage("Are you sure to logout?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                activity.finishAffinity();
                                System.exit(0);
                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        //show dialog
                        builder.show();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //return arraylist size
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}

