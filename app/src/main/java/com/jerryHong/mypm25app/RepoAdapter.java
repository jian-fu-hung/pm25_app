package com.jerryHong.mypm25app;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jerryHong.mypm25app.data.model.RepoAQIResponse;
import com.jerryHong.mypm25app.data.model.RepoGetResponse;
import com.jerryHong.mypm25app.data.model.RepoQiaotouResponse;
import com.jerryHong.mypm25app.databinding.PmItemBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> {

    List<RepoAQIResponse> item = new ArrayList<>();

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        PmItemBinding binding = PmItemBinding.inflate(layoutInflater, parent, false);
        return new RepoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder holder, int position) {
        RepoAQIResponse curruntRespone = item.get(position);
        if(!TextUtils.isEmpty(curruntRespone.getAQI())){
            holder.binding.tvMonitorDate.setText(curruntRespone.getSiteName());
            holder.binding.tvConcentration.setText("AQI：");
            holder.binding.tvItemUnit.setText(curruntRespone.getAQI());
        }
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public void setItem(List<RepoAQIResponse> item) {
        this.item = item;
        notifyDataSetChanged();
    }

    //    RepoAdapter(List<RepoGetResponse> items) {
//        this.items = items;
//    }

    void swapItems(List<RepoAQIResponse> newItems) {
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new RepoDiffCallback(this.item, newItems));
        this.item.clear();
        this.item.addAll(newItems);
        result.dispatchUpdatesTo(this);
    }
    class RepoViewHolder extends RecyclerView.ViewHolder {

        private PmItemBinding binding;

        RepoViewHolder(PmItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private class RepoDiffCallback extends DiffUtil.Callback {

        private List<RepoAQIResponse> mOldList;
        private List<RepoAQIResponse> mNewList;

        RepoDiffCallback(List<RepoAQIResponse> oldList, List<RepoAQIResponse> newList) {
            this.mOldList = oldList;
            this.mNewList = newList;
        }

        @Override
        public int getOldListSize() {
            return mOldList != null ? mOldList.size() : 0;
        }

        @Override
        public int getNewListSize() {
            return mNewList != null ? mNewList.size() : 0;
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
//            int oldId = mOldList.get(oldItemPosition).;
//            int newId = mNewList.get(newItemPosition).id;
            return Objects.equals(oldItemPosition, newItemPosition);
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            RepoAQIResponse oldRepo = mOldList.get(oldItemPosition);
            RepoAQIResponse newRepo = mNewList.get(newItemPosition);
            return Objects.equals(oldRepo, newRepo);
        }
    }
}
