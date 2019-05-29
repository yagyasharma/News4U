package com.example.ys.news4u.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;

import com.example.ys.news4u.Fragments.Fragment1;
import com.example.ys.news4u.Fragments.Fragment2;
import com.example.ys.news4u.R;

import android.content.Intent;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;


public class UsersListActivity extends AppCompatActivity{


    private AppCompatTextView textViewName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);

    }@Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preference, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.search:
            Fragment fr;
            fr=new Fragment2();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_place,fr);
            fragmentTransaction.commit();
            return(true);
        case R.id.logout:
            Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            return(true);

        case R.id.exit:
            android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Are you sure,You want to exit");
            alertDialogBuilder.setPositiveButton("yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            finish();
                        }
                    });

            alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(UsersListActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }





}

