package com.hehoo.phone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.androidkun.xtablayout.XTabLayout;
import com.hehoo.phone.R;
import com.hehoo.phone.homeFragment.NewsFragment;
import com.hehoo.phone.homeFragment.RecommendFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

//XTabLayout使用网址https://www.jianshu.com/p/9ae60dcb8f67
public class HomeFragment extends Fragment {
    @BindView(R.id.home_tab)
    XTabLayout homeTab;
    private FragmentManager mManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragent_home, container, false);
        ButterKnife.bind(this,v);
        initView();
        return v;
    }

    private void initView() {
        mManager = getChildFragmentManager();
        if (homeTab != null) {
            XTabLayout.Tab tab1 =  homeTab.newTab();
            tab1.setText("推荐");
            homeTab.addTab(tab1);
            XTabLayout.Tab tab2 =  homeTab.newTab();
            tab2.setText("新闻");
            homeTab.addTab(tab2);
          /*  XTabLayout.Tab tab = homeTab.newTab();
            View view1 = getLayoutInflater().inflate(R.layout.tab_home, null);
            TextView tv1 = view1.findViewById(R.id.tv);
            tv1.setText("推荐");
            tab.setCustomView(view1);
            homeTab.addTab(tab);
            XTabLayout.Tab tab2 = homeTab.newTab();
            View view2 = getLayoutInflater().inflate(R.layout.tab_home, null);
            TextView tv2 = view2.findViewById(R.id.tv);
            tv2.setText("新闻");
            tab2.setCustomView(view2);
            homeTab.addTab(tab2);*/
            RecommendFragment fragment = new RecommendFragment();
            NewsFragment newsFragment = new NewsFragment();
            mManager.beginTransaction().add(R.id.home_container,fragment,"recommend")
                    .show(fragment)
                    .add(R.id.home_container,newsFragment,"news")
                    .hide(newsFragment)
                    .commit();
            homeTab.addOnTabSelectedListener(new XTabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(XTabLayout.Tab tab) {
                    switch (tab.getPosition()) {
                        case 0:
                            mManager.beginTransaction().show(fragment).hide(newsFragment).commit();
                            break;
                        case 1:
                            mManager.beginTransaction().show(newsFragment).hide(fragment).commit();
                            break;
                    }
                }

                @Override
                public void onTabUnselected(XTabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(XTabLayout.Tab tab) {

                }
            });
        }
    }
}
