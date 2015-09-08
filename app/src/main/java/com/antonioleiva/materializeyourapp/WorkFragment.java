package com.antonioleiva.materializeyourapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class WorkFragment extends Fragment implements RecyclerViewAdapter.OnItemClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static List<Person> items = new ArrayList<>();

    static {
        for (int i = 1; i <= 2; i++) {
            //items.add(new ViewModel("Item " + i, "http://lorempixel.com/500/500/animals/" + i));
            items.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_launcher));
            items.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_launcher));
            items.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher));
        }
    }
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<MyAdapter.ViewHolder> mAdapter;
    //private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WorkFragment newInstance(String param1, String param2) {
        WorkFragment fragment = new WorkFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public WorkFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recycler);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_work, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_work);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(items);
        //adapter.setOnItemClickListener(this);
        //recyclerView.setAdapter(adapter);
       // String[] ar = new String[10];
        mAdapter = new MyAdapter(items);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

   /* // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

   /* @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
    }

    @Override
    public void onItemClick(View view, ViewModel viewModel) {
        DetailActivity.navigate((AppCompatActivity) getActivity(), view.findViewById(R.id.image), viewModel);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
 /*   public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }*/

}
