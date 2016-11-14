package com.example.smaug.notes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smaug.notes.R;
import com.example.smaug.notes.model.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Smaug on 31.10.2016.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


    private List<Note> mDataSource = null;

    public void setDataSource(List<Note> dataSource) {
        this.mDataSource = dataSource;
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
        Note note = mDataSource.get(position);
        holder.bindView(note);
    }

    @Override
    public int getItemCount() {
        if (mDataSource == null) {
            return 0;
        } else {
            return mDataSource.size();
        }

    }

    static class NotesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.primary_text_view)
        protected TextView mPrimaryTextView;
        @BindView(R.id.secondary_text_view)
        protected TextView mSecondaryTextView;
        @BindView(R.id.secondary2_text_view)
        protected TextView mSecondary2TextView;

        @BindView(R.id.date_text_view)
        protected TextView mDateTextView;


        //private TextView titleTextView = null;

        public NotesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            //titleTextView = (TextView) itemView.findViewById(R.id.primary_text_view);

        }

        void bindView(Note note) {
            mPrimaryTextView.setText(note.getTitle());
            mSecondaryTextView.setText(note.getText());
            mSecondary2TextView.setText(note.getText2());
            mDateTextView.setText(String.valueOf(note.getTime()));

        }
    }
}
