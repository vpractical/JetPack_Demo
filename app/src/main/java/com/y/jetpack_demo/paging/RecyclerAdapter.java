package com.y.jetpack_demo.paging;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.y.jetpack_demo.R;
import com.y.jetpack_demo.viewmodel.Girl;

public class RecyclerAdapter extends PagedListAdapter<Girl, RecyclerAdapter.RecyclerViewHolder> {


    protected RecyclerAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Girl concert = getItem(position);
        if (concert != null) {
            holder.ivIcon.setImageResource(concert.icon);
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_icon);
        }
    }

    private static DiffUtil.ItemCallback<Girl> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Girl>() {
                @Override
                public boolean areItemsTheSame(Girl oldConcert, Girl newConcert) {
                    return oldConcert == newConcert;
                }

                @Override
                public boolean areContentsTheSame(Girl oldConcert, Girl newConcert) {
//                    return oldConcert.icon == newConcert.icon;
                    return false;
                }
            };
}
