package com.iamkosgei.androidjetpackpaging.ui.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.iamkosgei.androidjetpackpaging.data.StudentDataSource;
import com.iamkosgei.androidjetpackpaging.data.StudentDataSourceFactory;
import com.iamkosgei.androidjetpackpaging.models.StudentsResponse;

public class StudentViewModel extends ViewModel {
    StudentDataSourceFactory studentDataSourceFactory = new StudentDataSourceFactory();
    public  LiveData<PagedList<StudentsResponse.Student>> studentPagedList;
    LiveData<PageKeyedDataSource<Integer, StudentsResponse.Student>> liveDataSource;

    public StudentViewModel() {
        liveDataSource = studentDataSourceFactory.getStudentLiveDataSource();

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setInitialLoadSizeHint(10)
                        .setPrefetchDistance(5)
                        .setEnablePlaceholders(true)
                        .setPageSize(StudentDataSource.PAGE_SIZE).build();

        studentPagedList = new LivePagedListBuilder<>(studentDataSourceFactory,
                pagedListConfig).build();

    }
}
