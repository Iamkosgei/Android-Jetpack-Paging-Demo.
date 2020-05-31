package com.iamkosgei.androidjetpackpaging.data;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.iamkosgei.androidjetpackpaging.api.RetrofitClient;
import com.iamkosgei.androidjetpackpaging.models.StudentsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentDataSource extends PageKeyedDataSource<Integer,StudentsResponse.Student> {
    public static final int PAGE_SIZE = 10;
    private static final int INITIAL_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, StudentsResponse.Student> callback) {
        RetrofitClient.getInstance().getApi().getStudents(INITIAL_PAGE).enqueue(new Callback<StudentsResponse>() {
            @Override
            public void onResponse(Call<StudentsResponse> call, Response<StudentsResponse> response) {
                callback.onResult(response.body().getData().getStudents(), 0, response.body().getData().getCount(),null, INITIAL_PAGE+1);
            }

            @Override
            public void onFailure(Call<StudentsResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, StudentsResponse.Student> callback) {
        RetrofitClient.getInstance().getApi().getStudents(params.key).enqueue(new Callback<StudentsResponse>() {
            @Override
            public void onResponse(Call<StudentsResponse> call, Response<StudentsResponse> response) {
                Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                if (response.body() != null) {
                    callback.onResult(response.body().getData().getStudents(), adjacentKey);
                }
            }

            @Override
            public void onFailure(Call<StudentsResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, StudentsResponse.Student> callback) {
        RetrofitClient.getInstance().getApi().getStudents(params.key).enqueue(new Callback<StudentsResponse>() {
            @Override
            public void onResponse(Call<StudentsResponse> call, Response<StudentsResponse> response) {
                Integer key = params.key < response.body().getData().getPages()  ?    params.key + 1 : null;
                if (response.body() != null) {
                    callback.onResult(response.body().getData().getStudents(), key);
                }
            }

            @Override
            public void onFailure(Call<StudentsResponse> call, Throwable t) {

            }
        });
    }
}
