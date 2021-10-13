package com.example.mockuphino;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<String> values;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public ListAdapter(List<String> myDataset) {
        values = myDataset;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.ebook_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final int name = holder.getAdapterPosition();
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(position);
            }
        });

        holder.txtFooter.setText("Footer: " + name);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
