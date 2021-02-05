package ghoneim.eservices.animeProject.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import ghoneim.eservices.animeProject.R;
import ghoneim.eservices.animeProject.model.Anime;

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

    public void bind(Anime anime) {
        textView.setText(anime.getTitle());
        Glide.with(itemView).load(anime.getImageUrl()).error(R.mipmap.ic_launcher)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }
}
