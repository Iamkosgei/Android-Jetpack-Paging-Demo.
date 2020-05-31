package com.iamkosgei.androidjetpackpaging.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ProgressBar;

import com.iamkosgei.androidjetpackpaging.R;
import com.iamkosgei.androidjetpackpaging.models.StudentsResponse;
import com.iamkosgei.androidjetpackpaging.ui.adapters.StudentAdapter;
import com.iamkosgei.androidjetpackpaging.ui.viewModel.StudentViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        //set up recyclerview
        recyclerView= findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //vm
        StudentViewModel studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);

        StudentAdapter studentAdapter = new StudentAdapter();

        studentViewModel.studentPagedList.observe(this, new Observer<PagedList<StudentsResponse.Student>>() {
            @Override
            public void onChanged(PagedList<StudentsResponse.Student> students) {
                studentAdapter.submitList(students);
            }
        });
        recyclerView.setAdapter(studentAdapter);
    }
}