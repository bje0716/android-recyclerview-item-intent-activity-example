package com.grapefruit.radio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grapefruit.radio.databinding.ItemBinding;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    public interface OnCallbackListener {
        void onCallback(String item);
    }

    private Context context;
    private String[] location;
    private int radioPosition = -1;
    private OnCallbackListener onCallback;

    public MainAdapter(Context context, OnCallbackListener onCallback) {
        super();
        this.context = context;
        this.onCallback = onCallback;
        location = context.getResources().getStringArray(R.array.location);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.binding.title.setText(location[position]);
        holder.binding.select.setChecked(position == radioPosition);
    }

    @Override
    public int getItemCount() {
        return location.length;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private ItemBinding binding;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemBinding.bind(itemView);

            View.OnClickListener listener = v -> {
                radioPosition = getAdapterPosition();
                notifyDataSetChanged();
                onCallback.onCallback(location[radioPosition]);
            };

            itemView.setOnClickListener(listener);
            binding.select.setOnClickListener(listener);
        }
    }
}
