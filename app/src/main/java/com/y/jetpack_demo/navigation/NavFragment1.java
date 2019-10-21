package com.y.jetpack_demo.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.y.jetpack_demo.R;
import com.y.jetpack_demo.util.L;

public class NavFragment1 extends Fragment {

    View view;
    int i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_nav1, container, false);
            view.findViewById(R.id.btn_self).setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.fm_nav1));
            view.findViewById(R.id.btn).setOnClickListener(v -> {
                Bundle bundle = new Bundle();
                bundle.putInt("i", i);
                Navigation.findNavController(view).navigate(R.id.fm_nav2, bundle);
            });
            // 每次view都是null，需要重绘，第二个打印确定每次的Fragment对象也不是同一个
            L.e("navFragment1: " + i++);
            L.e("navFragment1 = " + this.toString());
        }
        return view;
    }
}
