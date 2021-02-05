package ghoneim.eservices.animeProject.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ghoneim.eservices.animeProject.R;
import ghoneim.eservices.animeProject.adapter.AnimeAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowVerticalFragment extends Fragment {

    private RecyclerView recyclerView;

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
        View v = inflater.inflate(R.layout.fragment_show_anime, container, false);
        setupRecyclerView(v);
        return v;
    }

    private void setupRecyclerView(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        recyclerView.setAdapter(new AnimeAdapter(fragmentManager));
    }

}
