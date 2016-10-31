package com.example.smaug.notes.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smaug.notes.R;

import java.util.List;
import java.util.StringTokenizer;

import javax.sql.DataSource;

/**
 * Created by Smaug on 31.10.2016.
 */

public class NotesAdapter extends RecyclerView.Adapter <NotesAdapter.NotesViewHolder>{
    private List<String > dataSource = null;

    public void setDataSource(List<String> dataSource){
        this.dataSource = dataSource;
        notifyDataSetChanged(); //оповещение о том, что данные изменились, нужно перерисовать
    }

    @Override
    public NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());  //превращает Xml в Java код
        View view = layoutInflater.inflate(R.layout.view_notes_item, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {
        String title = dataSource.get(position);
        holder.bindView(title);
    }

    @Override
    public int getItemCount() {
        if (dataSource == null){
            return 0;
        }
        else {
            return dataSource.size();
        }

    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView = null;

        public NotesViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.title_text_view);

        }
        void bindView(String title){
            titleTextView.setText(title);
        }
    }
}
