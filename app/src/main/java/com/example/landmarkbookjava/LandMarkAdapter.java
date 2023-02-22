package com.example.landmarkbookjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.landmarkbookjava.databinding.RecycleRowBinding;

import java.util.ArrayList;

public class LandMarkAdapter extends RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder> {

    public ArrayList<LandMark> landMarkArrayList;

    public LandMarkAdapter(ArrayList<LandMark> landMarkArrayList) {
        this.landMarkArrayList = landMarkArrayList;
    }

    @NonNull
    @Override
    public LandMarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleRowBinding recycleRowBinding = RecycleRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        // instead of getLayoutInflater() use LayoutInflater.from()
        return new LandMarkHolder(recycleRowBinding);
    }



    @Override
    public void onBindViewHolder(@NonNull LandMarkAdapter.LandMarkHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.titleRecyclerText.setText(landMarkArrayList.get(position).name);
        holder.binding.contentRecyclerText.setText(landMarkArrayList.get(position).content);

        holder.binding.imageRecyclerView.setImageResource(landMarkArrayList.get(position).image);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("landmark", landMarkArrayList.get(position));

                // if you want to use singleton instead of intent
                /*
                Singleton singleton = Singleton.getInstance();
                singleton.setSentLandMark(landMarkArrayList.get(position));
                */

                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return landMarkArrayList.size(); // return the size of the array list
    }

    public class LandMarkHolder extends RecyclerView.ViewHolder{

        private RecycleRowBinding binding; // create a binding object

        public LandMarkHolder(RecycleRowBinding binding) {
            super(binding.getRoot());  // get the root of the binding
            this.binding = binding;
        }
    }


}



