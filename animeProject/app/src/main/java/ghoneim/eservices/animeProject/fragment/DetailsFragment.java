package ghoneim.eservices.animeProject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import ghoneim.eservices.animeProject.R;

public class DetailsFragment extends Fragment {

    private ImageView imageView;
    private TextView titleTextView;
    private TextView descriptionTextView;

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
        return v;
    }
}
