package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository {

	/**
	 * メールアドレス検索
	 * @return 利用者インスタンス
	 */
	User findByEmail();

}
