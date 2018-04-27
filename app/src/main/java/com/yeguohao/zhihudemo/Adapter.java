package com.yeguohao.zhihudemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private static final int NORMAL = 0;
    private static final int ADVERT = 1;

    private Bitmap bitmap;

    Adapter(Context context) {
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.advert);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView;
        if (viewType == ADVERT) {
            itemView = inflater.inflate(R.layout.item_advert, parent, false);
        } else {
            itemView = inflater.inflate(R.layout.item, parent, false);
        }
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        int type = getItemViewType(position);
        if (type == NORMAL) {
            String txt = position + "";
            ((TextView) holder.itemView).setText(txt);
        } else {
            ((AdvertImageView) holder.itemView).setBitmap(bitmap);
        }
    }

    @Override
    public int getItemCount() {
        return 40;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 20 ? ADVERT : NORMAL;
    }

    class Holder extends RecyclerView.ViewHolder {

        Holder(View itemView) {
            super(itemView);
        }

    }

}
