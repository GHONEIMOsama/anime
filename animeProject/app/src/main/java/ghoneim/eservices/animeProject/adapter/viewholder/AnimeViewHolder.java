package ghoneim.eservices.animeProject.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ghoneim.eservices.animeProject.R;

public class AnimeViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private ImageView imageView;

    public AnimeViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_text);
        imageView = itemView.findViewById(R.id.icon_imageview);
    }

    public TextView getTextView(){
        return textView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
