package com.ysl.ui.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ysl.R;
import com.ysl.view.BaseFragment;

/**
 * Description:数据
 * Change by:
 * Created by yang on 2017/10/12 17:07
 */

public class MessageFragment extends BaseFragment implements View.OnClickListener {

    private View mainView; // 缓存Fragment view

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mainView == null){
            mainView = inflater.inflate(R.layout.fragment_message,container,false);
        }
        return mainView;
    }

    @Override
    public void onClick(View v) {

    }
}
