package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	
	/**
	 * フィールド
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;          // 利用者ID
	private String name;     // 利用者氏名
	private String address;  // 住所
	private String email;    // メールアドレス
	private String phone;    // 電話番号
	private String password; // パスワード
	
	/**
	 * コンストラクタ
	 * @param name     利用者氏名
	 * @param address  住所
	 * @param email    メールアドレス
	 * @param phone    電話番号
	 * @param password パスワード
	 */
	public User(String name, String address, String email, String phone, String password) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
}
