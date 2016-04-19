package com.ndh.demo4ssh.repo;

import java.util.List;

import com.ndh.demo4ssh.domain.User;

public interface UserDao {
	public int save(User u);
	public List<User> findAll();
}
