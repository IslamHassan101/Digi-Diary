package com.example.digi_diary.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.digi_diary.Models.DiaryModel;
import com.example.digi_diary.R;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.myholder> {

private List<DiaryModel>diaryList;

    @NonNull
    @Override
    public DiaryAdapter.myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_diary_expended,
                parent,false);
        return new myholder(view);
    }

    public DiaryAdapter(List<DiaryModel> diaryList, SelectionPropagator selectionPropagator)
    {
        this.diaryList=diaryList;
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryAdapter.myholder holder, int position) {


    }

    class myholder extends RecyclerView.ViewHolder{


        public myholder(@NonNull View itemView) {
            super(itemView);


        }
    }
    @Override
    public int getItemCount() {
        return 0;
    }

    public interface SelectionPropagator {
        void propagateSelection(DiaryModel diary);
        void addToFavourites(DiaryModel diary);
        void removeFromFavourites(DiaryModel diary);
    }

}
