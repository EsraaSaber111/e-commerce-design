package com.smarteist.imageslider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;


public class TabFragment1 extends Fragment {


    private GridView gridview;
    private ArrayList<Beanclass> beanclassArrayList;
    private GridviewAdapter gridviewAdapter;
    private View view;

    private int[] IMAGEgrid = {R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4, R.drawable.w5, R.drawable.w1,};
    private String[] TITLeGgrid = {"Min 70% off", "Min 50% off", "Min 45% off",  "Min 60% off", "Min 70% off", "Min 50% off"};
    private String[] DIscriptiongrid = {"Wrist Watch", "Wrist Watch", "Wrist Watch","Wrist Watch", "Wrist Watch", "Wrist Watch"};
    private String[] Dategrid = {"Explore Now!","Grab Now!","Discover now!", "Great Savings!", "Explore Now!","Grab Now!"};




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmenttab1, container, false);

        gridview = view.findViewById(R.id.gridview);
        beanclassArrayList= new ArrayList<Beanclass>();

        for (int i= 0; i< IMAGEgrid.length; i++) {

            Beanclass beanclass = new Beanclass(IMAGEgrid[i], TITLeGgrid[i], DIscriptiongrid[i], Dategrid[i]);
            beanclassArrayList.add(beanclass);

        }
        gridviewAdapter = new GridviewAdapter(getActivity(), beanclassArrayList);

        gridview.setAdapter(gridviewAdapter);
     return view;

    }
}