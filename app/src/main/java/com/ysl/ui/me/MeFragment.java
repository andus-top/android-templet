package com.ysl.ui.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ysl.R;
import com.ysl.view.BaseFragment;

/**
 * Description:个人中心
 * Change by:
 * Created by yang on 2017/10/12 16:55
 */

public class MeFragment extends BaseFragment implements View.OnClickListener {

    private View mainView; // 缓存Fragment view

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mainView == null){
            mainView = inflater.inflate(R.layout.fragment_me,container,false);
        }
        return mainView;
    }

    @Override
    public void onClick(View v) {

    }
}
