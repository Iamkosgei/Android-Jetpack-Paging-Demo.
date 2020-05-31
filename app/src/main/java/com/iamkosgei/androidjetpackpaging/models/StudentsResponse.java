package com.iamkosgei.androidjetpackpaging.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StudentsResponse {
    @SerializedName("data")
    @Expose
    private Data data = new Data();

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("count")
        @Expose
        private Integer count;
        @SerializedName("page")
        @Expose
        private Integer page;
        @SerializedName("pages")
        @Expose
        private Integer pages;
        @SerializedName("students")
        @Expose
        private List<Student> students = new ArrayList<>();

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPages() {
            return pages;
        }

        public void setPages(Integer pages) {
            this.pages = pages;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }

    }

    public class Student {

        @SerializedName("lastname")
        @Expose
        private String lastName;
        @SerializedName("firstname")
        @Expose
        private String firstName;
        @SerializedName("form")
        @Expose
        private String form;
        @SerializedName("stream")
        @Expose
        private String stream;
        @SerializedName("id")
        @Expose
        private Integer id;

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getForm() {
            return form;
        }

        public void setForm(String form) {
            this.form = form;
        }

        public String getStream() {
            return stream;
        }

        public void setStream(String stream) {
            this.stream = stream;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

}
