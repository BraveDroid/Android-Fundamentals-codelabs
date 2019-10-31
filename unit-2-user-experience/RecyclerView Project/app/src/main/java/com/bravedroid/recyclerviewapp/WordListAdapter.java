package com.bravedroid.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> implements View.OnClickListener {
    private final LinkedList<String> mWordList;
    private final RecyclerView mRecyclerView;
    private LayoutInflater mInflater;


    public WordListAdapter(Context context, LinkedList<String> wordList, RecyclerView recyclerView) {
        mInflater = LayoutInflater.from(context);
        this.mRecyclerView = recyclerView;
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        mItemView.findViewById(R.id.image).setOnClickListener(this);
        return new WordViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    @Override
    public void onClick(View view) {
        int mPosition = mRecyclerView.getChildLayoutPosition((View) view.getParent());
        String element = mWordList.get(mPosition);
        mWordList.set(mPosition, "Clicked! " + element);
        notifyDataSetChanged();
    }

    //ViewHolder
    static class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
        }
    }
}
