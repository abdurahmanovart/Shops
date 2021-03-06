package com.github.arturx.shops;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.arturx.shops.bean.BaseResponse;
import com.github.arturx.shops.bean.ShopItem;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ShopsFragment.OnShopItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();

    }

    private void getData() {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://app.ecco-shoes.ru/shops/list")
                .newBuilder();
        String url = urlBuilder.build().toString();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                // TODO: 03.12.17 handle Failure
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (response.isSuccessful()) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    byte[] bytes = response.body().bytes();
                    final BaseResponse baseResponse = objectMapper.readValue(bytes, BaseResponse.class);
                    showShopFragment(baseResponse.getShopItems());
                } else {
                    // TODO: 03.12.17 Handle error
                }
            }
        });
    }

    private void showShopFragment(List<ShopItem> shopItems) {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.items_container, ShopsFragment.newInstance(shopItems))
                .commit();
    }


    @Override
    public void onFragmentInteraction(ShopItem item) {
        System.out.println("LOLEWLEMklAWND");
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.maps_container, MapViewFragment.newInstance(item.getLatitude(), item.getLongtitude()))
                .commit();
        Toast.makeText(this, "coordinates are" + item.getCountry(), Toast.LENGTH_LONG).show();
    }
}
