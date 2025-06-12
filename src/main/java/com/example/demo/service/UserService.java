package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public List<String> validate(User user) {
		// エラーリスト
		List<String> list = new ArrayList<String>();
		// 利用者名チェック
		if (!isRequired(user.getName())) {
			list.add(createRequiredError("氏名"));
		}
		// 住所チェック
		if (!isRequired(user.getAddress())) {
			list.add(createRequiredError("住所"));
		}
		// メールアドレスチェック
		if (!isRequired(user.getEmail())) {
			list.add(createRequiredError("メールアドレス"));
		} else if (!isUniue(user.getEmail())) {
			list.add(createDupelicatedError("メールアドレス"));
		}
		// 電話番号チェック
		if (!isRequired("電話番号")) {
			list.add(createDupelicatedError("電話番号"));
		}
		// パスワードチェック
		if (!isRequired("パスワード")) {
			list.add(createDupelicatedError("パスワード"));
		}
		// 戻り値の返却
		return list;
	}

	/**
	 * メールアドレス重複チェック
	 * @param email 検査対象メールアドレス
	 * @return 利用者インスタンスがある場合はfalse、それ以外はtrue
	 */
	private boolean isUniue(String email) {
		User user = repository.findByEmail();
		boolean result = true;
		if (user != null) {
			result = false;
		}
		return result;
	}

	/**
	 * 必須入力チェック
	 * @param target 検査対象文字列
	 * @return nullまたはから文字列の場合はfalse、それ以外はtrue
	 */
	private boolean isRequired(String target) {
		if (target == null) {
			target = "";
		}
		return (target.isEmpty());
	}


	/**
	 * 重複エラーメッセージを生成する
	 * @param field フィールド名
	 * @return エラーメッセージ
	 */
	private String createDupelicatedError(String field) {
		String message = "@fieldは重複しています";
		return message.replaceAll("@field", field);
	}

	/**
	 * 必須入力エラーメッセージを生成する
	 * @param field フィールド名
	 * @return エラーメッセージ
	 */
	private String createRequiredError(String field) {
		String message = "@fieldは必須です";
		return message.replaceAll("@field", field);
	}

}
