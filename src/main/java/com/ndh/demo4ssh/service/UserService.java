package com.ndh.demo4ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ndh.demo4ssh.domain.User;

public interface UserService {

	public void saveUsers(List<User> us);

	@Transactional(readOnly = true)
	public List<User> getAllUsers();
}
