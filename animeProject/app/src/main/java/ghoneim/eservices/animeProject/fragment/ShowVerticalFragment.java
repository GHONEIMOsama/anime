package ghoneim.eservices.animeProject.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import ghoneim.eservices.animeProject.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowVerticalFragment extends Fragment {


    public ShowVerticalFragment() {
        // Required empty public constructor
    }

    public static ShowVerticalFragment newInstance() {
        return new ShowVerticalFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_grid, container, false);
    }

}
