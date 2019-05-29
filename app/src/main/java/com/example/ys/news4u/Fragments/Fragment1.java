package com.example.ys.news4u.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.ys.news4u.R;
import com.example.ys.news4u.activities.MainActivity2;


public class Fragment1 extends Fragment {
    Button general;
    Button business;
    Button sports;
    Button celebrity;
    Button commit;
    String NEWS_SOURCE;
    String country;
    String endpoint;

    private Spinner spinner1;

    private static final String[] paths1 = {"US", "India", "France", "Belgium", "Germany"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment1, container, false);
        general=(Button)view.findViewById(R.id.button);
        business=(Button)view.findViewById(R.id.button2);
        sports=(Button)view.findViewById(R.id.button3);
        celebrity=(Button)view.findViewById(R.id.button4);
        commit = (Button) view.findViewById(R.id.button5);
        init();
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity2.class);
                String Source = null;
                endpoint = "top-headlines";
                intent.putExtra("Source", NEWS_SOURCE);
                intent.putExtra("country", country);
                intent.putExtra("endpoint", endpoint);
                startActivity(intent);

            }
        });
        spinner1 = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, paths1);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        country = "us";
                        break;
                    case 1:
                        country = "in";
                        break;
                    case 2:
                        country = "fr";
                        break;
                    case 3:
                        country = "be";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;   }
    public void init()
    {

        general.setOnClickListener(dbbuttonlistener);
        business.setOnClickListener(dbbuttonlistener);
        sports.setOnClickListener(dbbuttonlistener);
        celebrity.setOnClickListener(dbbuttonlistener);

    }

    private  View.OnClickListener dbbuttonlistener= new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.button:
                    NEWS_SOURCE="general";
                    break;
                case R.id.button2:
                    NEWS_SOURCE="business";
                    break;
                case R.id.button3:
                    NEWS_SOURCE="sports";
                    break;
                case R.id.button4:
                    NEWS_SOURCE="entertainment";
                    break;

            }

        }

    };

}
