package com.example.nagoyameshi.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Role;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.SignupForm;
import com.example.nagoyameshi.form.UserEditForm;
import com.example.nagoyameshi.repository.RoleRepository;
import com.example.nagoyameshi.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;        
        this.passwordEncoder = passwordEncoder;
    }    
    
    @Transactional
    public User create(SignupForm signupForm) {
        User user = new User();
        Role role = roleRepository.findByName("ROLE_GENERAL");
        
        user.setName(signupForm.getName());
        user.setRuby(signupForm.getRuby());
        user.setPostNumber(signupForm.getPostNumber());
        user.setAddress(signupForm.getAddress());
        user.setPhoneNumber(signupForm.getPhoneNumber());
        user.setBirthday(signupForm.getBirthday());
        user.setJob(signupForm.getJobId());
        user.setEmail(signupForm.getEmail());
        user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
        user.setRole(role);
        user.setEnabled(false);
        
        return userRepository.save(user);
    }   
    
    @Transactional
    public void update(UserEditForm userEditForm) {
    	User user = userRepository.getReferenceById(userEditForm.getId());
    	
    	user.setName(userEditForm.getName());
    	user.setRuby(userEditForm.getRuby());
    	user.setPostNumber(userEditForm.getPostNumber());
    	user.setAddress(userEditForm.getAddress());
    	user.setPhoneNumber(userEditForm.getPhoneNumber());
    	user.setBirthday(userEditForm.getBirthday());
    	user.setJob(userEditForm.getJobId());
    	user.setEmail(userEditForm.getEmail());
    }
    
    @Transactional
    public void roleChange(Integer subscribeId) {
    	User user = userRepository.getReferenceById(subscribeId);
    	Role role = roleRepository.findByName("ROLE_PREMIUM");
    	
    	user.setRole(role);
    }
    
    //メールアドレスが登録済みかどうかをチェックする
    public boolean isEmailRegistered(String email) {
    	User user = userRepository.findByEmail(email);
    	return user != null;
    }
    
    //パスワードの一致テスト
    public boolean isSamePassword(String password, String passwordConfirmation) {
    	return password.equals(passwordConfirmation);
    }
    
    //メールアドレスが変更されたかどうかをチェックする
    public boolean isEmailChanged(UserEditForm userEditForm) {
    	User currentUser = userRepository.getReferenceById(userEditForm.getId());
    	return !userEditForm.getEmail().equals(currentUser.getEmail());
    }
    
    //ユーザーを有効にする
    @Transactional
    public void enableUser(User user) {
    	user.setEnabled(true);
    	userRepository.save(user);
    }
}

