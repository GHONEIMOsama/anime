package ghoneim.eservices.animeProject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ghoneim.eservices.animeProject.R;
import ghoneim.eservices.animeProject.adapter.viewholder.AnimeViewHolder;
import ghoneim.eservices.animeProject.model.Anime;


public class AnimeAdapter extends RecyclerView.Adapter<AnimeViewHolder> {

    private List<Anime> animeList;
    private FragmentManager fragmentManager;

    public AnimeAdapter(FragmentManager fragmentManager) {
        animeList = new ArrayList<>();
        animeList.addAll(DataGenerator.generateData());
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new AnimeViewHolder(view, fragmentManager);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        holder.bind(animeList.get(position));
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }
}
