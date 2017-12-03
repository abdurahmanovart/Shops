package com.github.arturx.shops.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.List;

/**
 * Created by arturx on 03.12.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse {

    @JsonProperty("meta")
    private Meta mMeta;

    @JsonProperty("data")
    private List<ShopItem> mShopItems;

    public Meta getMeta() {
        return mMeta;
    }

    public List<ShopItem> getShopItems() {
        return mShopItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponse that = (BaseResponse) o;
        return Objects.equal(mMeta, that.mMeta) &&
                Objects.equal(mShopItems, that.mShopItems);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mMeta, mShopItems);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("mMeta", mMeta)
                .add("mShopItems", mShopItems)
                .toString();
    }
}
