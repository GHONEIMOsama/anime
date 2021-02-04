package ghoneim.eservices.animeProject.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ghoneim.eservices.animeProject.R;
import ghoneim.eservices.animeProject.adapter.AnimeAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowGridFragment extends Fragment {

    private RecyclerView recyclerView;

    public ShowGridFragment() {
        // Required empty public constructor
    }

    public static ShowGridFragment newInstance() {
        return new ShowGridFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_show_vertical, container, false);
        setupRecyclerView(v);
        return v;
    }

    private void setupRecyclerView(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.vertical_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(), 2));
        recyclerView.setAdapter(new AnimeAdapter());
    }

}
