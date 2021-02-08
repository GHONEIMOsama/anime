package ghoneim.eservices.animeProject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

import ghoneim.eservices.animeProject.R;
import ghoneim.eservices.animeProject.viewmodel.AnimeViewModel;
import ghoneim.eservices.animeProject.viewmodel.AnimeViewModelFractory;

public class DetailsFragment extends Fragment {

    private ImageView imageView;
    private TextView titleTextView;
    private TextView descriptionTextView;
    private AnimeViewModel animeViewModel;

    public DetailsFragment() {}

    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        imageView = (ImageView) v.findViewById(R.id.anime_image);
        titleTextView = (TextView) v.findViewById(R.id.anime_title);
        descriptionTextView = (TextView) v.findViewById(R.id.anime_description);

        animeViewModel = new ViewModelProvider(requireActivity(), new AnimeViewModelFractory()).get(AnimeViewModel.class);

        titleTextView.setText(animeViewModel.getAnime().getValue().getTitle());
        descriptionTextView.setText(animeViewModel.getAnime().getValue().getDescription());
        Glide.with(v).load(animeViewModel.getAnime().getValue().getImageUrl()).error(R.mipmap.ic_launcher)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageView);
        return v;
    }
}
