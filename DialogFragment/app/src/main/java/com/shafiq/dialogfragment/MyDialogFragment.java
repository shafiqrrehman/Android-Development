package com.shafiq.dialogfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyDialogFragment
 * to handle interaction events.
 */
public class MyDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnYes;
    private Button btnNo;
    private Communicator comm;

    public MyDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        comm = (Communicator) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_dialog, container, false);

        btnYes = view.findViewById(R.id.yes);
        btnNo = view.findViewById(R.id.no);

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

        setCancelable(false);

        return view;
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.yes) {

            comm.respond("Yes was Clicked");
            dismiss();

        } else if (id == R.id.no) {

            comm.respond("No was Clicked");
            dismiss();
        }
    }

    public interface Communicator{

        public void respond(String msg);
    }
}
