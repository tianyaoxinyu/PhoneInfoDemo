package com.hehoo.phone.adapter;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hehoo.phone.R;

import java.util.List;

public class AreasAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public AreasAdapter(@Nullable List<String> data) {
        super(R.layout.item_register_area,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        TextView tv = (TextView) helper.itemView;
        tv.setText(item);
    }
}
