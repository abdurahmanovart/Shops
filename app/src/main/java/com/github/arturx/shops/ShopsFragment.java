package com.github.arturx.shops;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.arturx.shops.Adapter.OnShopItemClickListener;
import com.github.arturx.shops.Adapter.ShopItemAdapter;
import com.github.arturx.shops.bean.ShopItem;

import java.util.ArrayList;
import java.util.List;


public class ShopsFragment extends Fragment implements OnShopItemClickListener {
    private static final String EXTRA_SHOPS = "extra_shops";

    private List<ShopItem> mShopItemList;
    private ShopItemAdapter mAdapter;

    private OnShopItemClickListener mListener;

    public static ShopsFragment newInstance(List<ShopItem> shops) {
        ShopsFragment fragment = new ShopsFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(EXTRA_SHOPS, (ArrayList<? extends Parcelable>) shops);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mShopItemList = getArguments().getParcelableArrayList(EXTRA_SHOPS);
            mAdapter = new ShopItemAdapter(mShopItemList,this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shops, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnShopItemClickListener)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(int position) {
        if (mListener == null) {
            mListener.onFragmentInteraction(mShopItemList.get(position));
        }
    }

    public interface OnShopItemClickListener {
        void onFragmentInteraction(ShopItem item);
    }
}
