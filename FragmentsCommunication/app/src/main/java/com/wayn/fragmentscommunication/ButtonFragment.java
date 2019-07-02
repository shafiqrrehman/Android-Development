package com.wayn.fragmentscommunication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {

    @BindView(R.id.button)
    Button button;
    int counter;
    Communicator comm;

    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_button, container, false);
        ButterKnife.bind(this, v);

        return v;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();
    }

    @OnClick(R.id.button)
    public void buttonCliked() {

        counter++;
        comm.respond("The button was clicked " + counter + " times.");
    }
}
