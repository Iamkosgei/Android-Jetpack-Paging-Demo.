package com.iamkosgei.androidjetpackpaging.data;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.iamkosgei.androidjetpackpaging.models.StudentsResponse;

public class StudentDataSourceFactory extends DataSource.Factory<Integer, StudentsResponse.Student> {
    private MutableLiveData<PageKeyedDataSource<Integer, StudentsResponse.Student>> studentLiveDataSource = new MutableLiveData<>();
    StudentDataSource studentDataSource = new StudentDataSource();
    @NonNull
    @Override
    public DataSource<Integer, StudentsResponse.Student> create() {
        studentLiveDataSource.postValue(studentDataSource);
        return studentDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, StudentsResponse.Student>> getStudentLiveDataSource(){
        return studentLiveDataSource;
    }
}
