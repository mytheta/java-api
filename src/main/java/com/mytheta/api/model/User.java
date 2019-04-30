package com.mytheta.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users") // データベースのテーブル名を指定している
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id // テーブルの主キーであることを示す
    private String id;
    @Column(nullable = false) // テーブルのカラムを示す．nullable = false はnull許可していないことを示す
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String grade;
    @Column(nullable = false)
    private int role;
    private String thesis;

    //全てを引数に持つコンストラクタ
    public User(String id, String name, String password, String grade, int role, String thesis) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.grade = grade;
        this.role = role;
        this.thesis = thesis;
    }

    //空のコンストラクタ
    public User() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getGrade() {
        return grade;
    }

    public int getRole() {
        return role;
    }

    public String getThesis() {
        return thesis;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }
}
