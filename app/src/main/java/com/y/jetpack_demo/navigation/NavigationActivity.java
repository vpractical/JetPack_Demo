package com.y.jetpack_demo.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.y.jetpack_demo.R;

/**
 * 切换的navigate()方法，是通过replace()方法实现的，所以fragment不会保存状态，每次都是新的
 */
public class NavigationActivity extends AppCompatActivity {

    public static void start(Context context){
        Intent intent = new Intent(context, NavigationActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Fragment fm = getSupportFragmentManager().findFragmentById(R.id.fm_nav);
        assert fm != null;
        return NavHostFragment.findNavController(fm).navigateUp();
    }
}
