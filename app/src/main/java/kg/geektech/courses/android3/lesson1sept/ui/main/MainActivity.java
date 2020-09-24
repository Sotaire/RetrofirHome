package kg.geektech.courses.android3.lesson1sept.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import kg.geektech.courses.android3.lesson1sept.App;
import kg.geektech.courses.android3.lesson1sept.R;
import kg.geektech.courses.android3.lesson1sept.data.models.Book;
import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;
import kg.geektech.courses.android3.lesson1sept.data.network.GhibliService;

public class MainActivity
        extends AppCompatActivity
        implements MainContract.View {

    RecyclerView recyclerView;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.films_recycler);
        mainAdapter = new MainAdapter();
        recyclerView.setAdapter(mainAdapter);

        App.ghibliService.getFilms(new GhibliService.GhibliFilmsCallback() {
            @Override
            public void onSuccess(List<FilmModel> filmModel) {
                Log.d("GHIBLI", String.valueOf(filmModel.size()));
                mainAdapter.setFilmModels(filmModel);
            }

            @Override
            public void onFailure(Throwable ex) {
                Log.d("GHIBLI",ex.getMessage());
            }
        });



    }

    @Override
    public void showBook(Book book) {
    }

}