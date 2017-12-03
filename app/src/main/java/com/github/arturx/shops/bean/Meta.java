package com.github.arturx.shops.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

/**
 * Created by arturx on 03.12.17.
 */

public class Meta {

    @JsonProperty("code")
    private int mCode;

    @JsonProperty("error_message")
    private String mErrorMessage;

    @JsonProperty("rows_count")
    private int mRowsCount;

    public int getCode() {
        return mCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public int getRowsCount() {
        return mRowsCount;
    }

    @JsonIgnore
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("mCode", mCode)
                .add("mErrorMessage", mErrorMessage)
                .add("mRowsCount", mRowsCount)
                .toString();
    }


    @JsonIgnore
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meta meta = (Meta) o;
        return mCode == meta.mCode &&
                mRowsCount == meta.mRowsCount &&
                Objects.equal(mErrorMessage, meta.mErrorMessage);
    }

    @JsonIgnore
    @Override
    public int hashCode() {
        return Objects.hashCode(mCode, mErrorMessage, mRowsCount);
    }
}
