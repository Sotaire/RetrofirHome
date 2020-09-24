package kg.geektech.courses.android3.lesson1sept.ui.main;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.courses.android3.lesson1sept.R;
import kg.geektech.courses.android3.lesson1sept.data.models.FilmModel;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.FilmHolder> {

    List<FilmModel> filmModels = new ArrayList<>();

    public void setFilmModels(List<FilmModel> filmModels) {
        this.filmModels = filmModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilmHolder(LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.film_view_holder,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {
        holder.onBind(filmModels.get(position).getTitle(),filmModels.get(position).getDirector());
    }

    @Override
    public int getItemCount() {
        return filmModels.size();
    }

    public class FilmHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView director;

        public FilmHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_tv);
            director = itemView.findViewById(R.id.director_tv);
        }

        public void onBind(String title,String director){
            this.title.setText(title);
            this.director.setText(director);
        }

    }
}
