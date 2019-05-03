package com.example.android.recyclerviewproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ExampleViewHolder> {

    private ArrayList<Item> mItemList;
    private OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextView1;
        private TextView mTextView2;
        private ImageView mImageDelete;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mImageDelete = itemView.findViewById(R.id.imageDelete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            mImageDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public CustomAdapter(ArrayList<Item> itemList) {
        mItemList = itemList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(view, mItemClickListener);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        Item currentItem = mItemList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}
