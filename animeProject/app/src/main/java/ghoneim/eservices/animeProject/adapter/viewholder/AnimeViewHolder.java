package ghoneim.eservices.animeProject.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ghoneim.eservices.animeProject.R;

public class AnimeViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public AnimeViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.randomText);
    }

    public TextView getView(){
        return textView;
    }
}
