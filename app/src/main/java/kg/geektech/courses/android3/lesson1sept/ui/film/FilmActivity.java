package kg.geektech.courses.android3.lesson1sept.ui.film;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import kg.geektech.courses.android3.lesson1sept.R;

public class FilmActivity extends AppCompatActivity {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
//        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
//        Fragment navhost = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
//        NavController c = NavHostFragment.findNavController(navhost);
        navController = Navigation.findNavController(this,R.id.nav_host_fragment);
    }
}