package com.mytheta.api.repositories;

import com.mytheta.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// JpaRepositoryを継承している
// JpaRepositoryではデータベースのCRUD操作のメソッドが自動で実装されている
// findAll テーブルのデータを全件取得
// getById 主キーを引数にテーブルからデータを1件取得
// save テーブルに対応するEntityクラスを引数にテーブルからデータを1件保存/更新
// delete 主キーを引数にテーブルからデータを1件削除
// ※保存と更新は同じメソッド名で行う

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}

