package com.example.smaug.notes;

import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.smaug.notes.adapters.NotesAdapter;
import com.example.smaug.notes.model.Note;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesActivity extends AppCompatActivity {

    @BindView(R.id.activity_notes)
    protected RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

  //  private RecyclerView recyclerView = null;
 //   private Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ButterKnife.bind(this);
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);


        //recyclerView = (RecyclerView) findViewById(R.id.activity_notes);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        NotesAdapter adapter = new NotesAdapter();
        List<Note> dataSource = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            long yourmillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.US);
            GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("US/Central"));
            calendar.setTimeInMillis(yourmillis);

            Note note = new Note();
            note.setTitle("Note #"+i);
            note.setText("  text: " + i);
            note.setText2("  text2: " + i*2);
            note.setTime(simpleDateFormat.format(calendar.getTime()));
            dataSource.add(note);
        }
        recyclerView.setAdapter(adapter);
        adapter.setDataSource(dataSource);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.notes_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();
        switch (id) {
            case R.id.menu1:
                Snackbar.make(recyclerView, R.string.menu1, Snackbar.LENGTH_LONG).show();

                return true;
            case R.id.menu2:
                Snackbar.make(recyclerView, R.string.menu2, Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.menu3:
                Snackbar.make(recyclerView, R.string.menu4, Snackbar.LENGTH_INDEFINITE).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
