package com.htxf.safetymanual.general;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htxf.safetymanual.R;

/**
 * Created by Administrator on 2016/5/21.
 * 是GeneralSafetyRules下的一个Fragment。是第二级的Fragment。是目录下一章的一小节。
 */
public class GeneralRules extends Fragment {

    RecyclerView mRecyclerView;

    GeneralRulesRecyclerViewAdapter mAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.general_rules,container,false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.general_rules_recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] data = {"a","b","c"};
        mAdapter = new GeneralRulesRecyclerViewAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
    }
}
