package com.hehoo.phone.popup;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hehoo.phone.R;
import com.hehoo.phone.adapter.AreasAdapter;

import java.util.List;

import razerdp.basepopup.BasePopupWindow;

public class AreaCodeListPop extends BasePopupWindow {
    private AreaClickListener mAreaClickListener;
    public AreaCodeListPop(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public void setAreas(List list) {
        RecyclerView view = (RecyclerView) getContentView();
        AreasAdapter adapter = new AreasAdapter(list);
        view.setLayoutManager(new LinearLayoutManager(getContext()));
        view.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter1, view1, position) -> {
            if (mAreaClickListener != null) mAreaClickListener.onAreaClickListener(adapter.getItem(position));
        });
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.popup_area_codes);
    }

    public void setAreaClickListener(AreaClickListener areaClickListener) {
        mAreaClickListener = areaClickListener;
    }

    public interface AreaClickListener {
        void onAreaClickListener(String area);
    }
}
