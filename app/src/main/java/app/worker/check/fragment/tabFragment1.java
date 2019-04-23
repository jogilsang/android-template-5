package app.worker.check.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.worker.check.kakasubstitutedriving.R;

/**
 * Created by user on 2018-06-10.
 */

public class tabFragment1 extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab_1, container, false);

        initView(rootView);

        initSet();

        initData();

        setListener();

        return rootView;
    }

    public void initView(View v){



    }

    public void setListener() {

    }

    public void initSet(){


    }



    public void initData(){




    }

}