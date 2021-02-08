package ghoneim.eservices.animeProject.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import ghoneim.eservices.animeProject.R;
import ghoneim.eservices.animeProject.fragment.DetailsFragment;
import ghoneim.eservices.animeProject.model.Anime;
import ghoneim.eservices.animeProject.viewmodel.AnimeViewModel;
import ghoneim.eservices.animeProject.viewmodel.AnimeViewModelFractory;


public class AnimeViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    private ImageView imageView;
    private TextView descriptionView;
    private String imageUrl;
    private AnimeViewModel animeViewModel;

    public AnimeViewHolder(@NonNull View itemView, final FragmentActivity fragmentActivity) {
        super(itemView);
        textView = itemView.findViewById(R.id.title_text);
        imageView = itemView.findViewById(R.id.icon_imageview);
        descriptionView = itemView.findViewById(R.id.description_text);

        animeViewModel = new ViewModelProvider(fragmentActivity, new AnimeViewModelFractory()).get(AnimeViewModel.class);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Anime anime = new Anime(textView.getText().toString(), descriptionView.getText().toString(), imageUrl);
                animeViewModel.setAnime(anime);
                FragmentTransaction fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, DetailsFragment.newInstance());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    public TextView getTextView(){
        return textView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void bind(Anime anime) {
        textView.setText(anime.getTitle());
        descriptionView.setText(anime.getDescription());
        imageUrl = anime.getImageUrl();
        Glide.with(itemView).load(anime.getImageUrl()).error(R.mipmap.ic_launcher)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
    }
}
