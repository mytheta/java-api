package com.mytheta.api.service;


import com.mytheta.api.model.User;
import com.mytheta.api.model.UserForm;
import com.mytheta.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // このServiceクラスで呼び出すRepositoryを宣言する
    // @Autowiredアノテーション SpringBootではインスタンスの管理をDIコンテナという技術で行う．開発者はインスタンスの生成・破棄を意識する必要がない．
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public UserForm getUser(String id) {

        User user = userRepository.getOne(id);
        UserForm userForm = new UserForm(user.getId(), user.getName(), user.getGrade(), user.getRole(), user.getThesis());
        return userForm;
    }

    public List<UserForm> getUsers() {

        List<UserForm> userForms = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            UserForm userForm = new UserForm(user.getId(), user.getName(), user.getGrade(), user.getRole(), user.getThesis());
            userForms.add(userForm);
        }
        return userForms;
    }

    public void upgrade(String userId) {
        User user = userRepository.getOne(userId);
        switch (user.getGrade()) {
            case "B3":
                user.setGrade("B4");
                break;
            case "B4":
                user.setGrade("M1");
                break;
            case "M1":
                user.setGrade("M2");
                break;
        }
        userRepository.save(user);

    }

    public void graduate(String userId) {
        User user = userRepository.getOne(userId);
        String grade = user.getId().substring(0,3);
        grade = grade +"（既卒）";
        user.setGrade(grade);
        userRepository.save(user);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
