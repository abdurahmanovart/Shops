package com.github.arturx.shops.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.arturx.shops.R;
import com.github.arturx.shops.bean.ShopItem;

import java.util.List;

/**
 * Created by arturx on 03.12.17.
 */

public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemViewHolder> {

    private final List<ShopItem> mShopItemList;

    public ShopItemAdapter(List<ShopItem> shopItemList,
                           OnShopItemClickListener clickListener) {
        mShopItemList = shopItemList;
        mClickListener = clickListener;
    }

    private final OnShopItemClickListener mClickListener;

    @Override
    public ShopItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_item,parent,false);
        return new ShopItemViewHolder(view,mClickListener);
    }

    @Override
    public void onBindViewHolder(ShopItemViewHolder holder, int position) {
        ShopItem item = mShopItemList.get(position);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(item.getCountry());
        stringBuilder.append(" ");
        stringBuilder.append(item.getTown());
        stringBuilder.append(" ");
        stringBuilder.append(item.getMetro());
        stringBuilder.append(" ");
        stringBuilder.append(item.getAddress());
        stringBuilder.append(" ");
        stringBuilder.append(item.getPhone());
        holder.setAdress(stringBuilder.toString());
    }

    @Override
    public int getItemCount() {
        return mShopItemList.size();
    }
}
