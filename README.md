## userAPI

+ カレントディレクトリは/user-api

|HTTPメソッド|エンドポイント|機能|
| -- | --| -- |
|GET| /users | 学生一覧の取得 |
|GET| /users/student| 現役の学生を取得 |
|GET| /users/:id | 1人の学生を取得 |
|PUT| /users/grade/:id | 学年を１つ繰り上げる |
|PUT| /users/graduate/:id |卒業させる|
|POST| /users | 学生の登録 |
|DELETE| /users/:id | 学生の削除 |


## 設定
```
$ docker network create spring
$ docker-compose -f infra/mysql/docker-compose.yml up -d
$ docker-compose up 

```
