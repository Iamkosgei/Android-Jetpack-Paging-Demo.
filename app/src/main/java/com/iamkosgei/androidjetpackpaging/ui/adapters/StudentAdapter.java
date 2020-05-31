package com.iamkosgei.androidjetpackpaging.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.iamkosgei.androidjetpackpaging.R;
import com.iamkosgei.androidjetpackpaging.models.StudentsResponse;

import java.util.Locale;

public class StudentAdapter extends PagedListAdapter<StudentsResponse.Student, StudentAdapter.StudentViewHolder> {


    public StudentAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,parent, false);
        return new StudentViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.BindStudent(getItem(position));

    }

    public static DiffUtil.ItemCallback<StudentsResponse.Student> DIFF_CALLBACK = new DiffUtil.ItemCallback<StudentsResponse.Student>() {
        @Override
        public boolean areItemsTheSame(@NonNull StudentsResponse.Student oldItem, @NonNull StudentsResponse.Student newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull StudentsResponse.Student oldItem, @NonNull StudentsResponse.Student newItem) {
            return oldItem.getFirstName().equals(newItem.getFirstName())
                    && oldItem.getLastName().equals(newItem.getLastName())
                    && oldItem.getForm().equals(newItem.getForm())
                    && oldItem.getStream().equals(newItem.getStream());
        }
    };

    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView name, form,stream;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            form = itemView.findViewById(R.id.form);
            stream =itemView.findViewById(R.id.stream);
        }

        public void BindStudent(StudentsResponse.Student student){
            name.setText(String.format(Locale.ENGLISH,"%s %s", student == null ? "...": student.getFirstName() , student== null? " " : student.getLastName()));
            form.setText(student == null ? "...": student.getForm());
            stream.setText(student == null ? "...": student.getStream());
        }
    }
}
