package ghoneim.eservices.animeProject.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

import ghoneim.eservices.animeProject.R;
import ghoneim.eservices.animeProject.adapter.viewholder.AnimeViewHolder;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeViewHolder> {


    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        holder.getView().setText("Attack on Titans" + new Random(100).nextInt());
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
