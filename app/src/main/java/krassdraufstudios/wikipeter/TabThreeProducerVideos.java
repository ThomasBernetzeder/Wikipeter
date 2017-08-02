package krassdraufstudios.wikipeter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Krass Drauf on 02.08.2017.
 */

public class TabThreeProducerVideos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Get the view from fragment_tab_three_producer_videos
        View rootView = inflater.inflate(R.layout.fragment_tab_three_producer_videos, container, false);

        return rootView;

    }
}
