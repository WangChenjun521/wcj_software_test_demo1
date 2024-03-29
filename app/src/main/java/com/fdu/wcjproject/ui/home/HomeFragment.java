package com.fdu.wcjproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.util.Log;

import com.fdu.wcjproject.MainActivity;
import com.fdu.wcjproject.R;
import com.fdu.wcjproject.SearchActivity;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    public Button btn1,buttonToSearch;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

       // View v = inflater.inflate(R.layout.fragment_home, container, false);
        btn1 =(Button)root.findViewById(R.id.buttonHome);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setText("THIS is a button from wangchenjun");
                System.out.println("THIS is a button from wangchenjun");
                Log.d("MainActivity","hi! I am wangchenjun");
                Toast.makeText(getActivity(),"您点了一下汪陈军的按钮！", Toast.LENGTH_SHORT).show();
            }
        });

        buttonToSearch=(Button)root.findViewById(R.id.buttonToSearch);
        buttonToSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  buttonToSearch.setText("这是汪陈军的按钮");
                Intent intent=new Intent(buttonToSearch.getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }
}