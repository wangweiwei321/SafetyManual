package com.htxf.safetymanual.general;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htxf.safetymanual.FragmentAdapter;
import com.htxf.safetymanual.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/21.
 * 这是总的第一级的Fragment。是MainActivity下的一个Fragment。是目录下的一章。
 */
public class GeneralSafetyRulesFragment extends Fragment{

    public static TabLayout sTabLayout;
    public static ViewPager sViewPager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.general_safety_rules, null);

        //设置ToolBar
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setSubtitle("实验室一般安全守则");


        //设置ActionBar
        final ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        ab.setDisplayHomeAsUpEnabled(true);


        sTabLayout = (TabLayout) view.findViewById(R.id.tabs);
        sViewPager = (ViewPager) view.findViewById(R.id.viewpager);


        List<String> titles = new ArrayList<>();
        titles.add("一般守则");
        titles.add("安全与维护");
        titles.add("警告牌");
        titles.add("无人在守的实验");
        sTabLayout.addTab(sTabLayout.newTab().setText(titles.get(0)));
        sTabLayout.addTab(sTabLayout.newTab().setText(titles.get(1)));
        sTabLayout.addTab(sTabLayout.newTab().setText(titles.get(2)));
        sTabLayout.addTab(sTabLayout.newTab().setText(titles.get(3)));

        sTabLayout.setTabMode(0);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new GeneralRules());
        fragments.add(new SafetyAndMaintenance());
        fragments.add(new GeneralRules());
        fragments.add(new SafetyAndMaintenance());


        FragmentAdapter adapter =
                new FragmentAdapter(getChildFragmentManager(), fragments, titles);

        sViewPager.setAdapter(adapter);
        sTabLayout.setupWithViewPager(sViewPager);
        sTabLayout.setTabsFromPagerAdapter(adapter);

        return view;

    }


}

