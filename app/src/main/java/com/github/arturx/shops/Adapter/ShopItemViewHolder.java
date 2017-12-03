package com.github.arturx.shops.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.arturx.shops.R;

/**
 * Created by arturx on 03.12.17.
 */

class ShopItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private OnShopItemClickListener mClickListener;

    private TextView mAddressTextView;

    public ShopItemViewHolder(View itemView, OnShopItemClickListener clickListener) {
        super(itemView);
        mClickListener = clickListener;
        itemView.setOnClickListener(this);
        mAddressTextView = (TextView) itemView.findViewById(R.id.address_text_view);
    }

    public void setAdress(String text){
        mAddressTextView.setText(text);
    }

    @Override
    public void onClick(View v) {
        mClickListener.onClick(getLayoutPosition());
    }
}
