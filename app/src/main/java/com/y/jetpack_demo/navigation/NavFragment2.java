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

public class NavFragment2 extends Fragment {

    View view;
    int i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        if(bundle != null){
            i = bundle.getInt("i",-1);
        }

        if(view == null){
            view = inflater.inflate(R.layout.fragment_nav2,container,false);
            L.e("navFragment2: " + i);
            view.findViewById(R.id.btn).setOnClickListener(v -> Navigation.findNavController(view).navigate(R.id.fm_nav1));
        }

        return view;
    }
}
