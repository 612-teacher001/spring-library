-- テーブル削除
DROP TABLE IF EXISTS ndc_master CASCADE;
DROP TABLE IF EXISTS role_master CASCADE;
DROP TABLE IF EXISTS media_master CASCADE;
DROP TABLE IF EXISTS status_master CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS material_catalogues CASCADE;
DROP TABLE IF EXISTS material_ledgers CASCADE;
DROP TABLE IF EXISTS loans CASCADE;

-- 日本十進分類コードマスター
CREATE TABLE ndc_master (
	id   INTEGER    PRIMARY KEY,
	name VARCHAR(5) NOT NULL
);
-- 権限マスター
CREATE TABLE role_master (
	id   SERIAL     PRIMARY KEY,
	name VARCHAR(8) NOT NULL
);
-- 媒体マスタ：書籍(1)、雑誌(2)、CD/DVD(3)
CREATE TABLE media_master (
	id   SERIAL     PRIMARY KEY,
	name VARCHAR(15) NOT NULL
);
-- 資料状況マスター
CREATE TABLE status_master (
	id   SERIAL     PRIMARY KEY,
	name VARCHAR(5) NOT NULL
);
-- 利用者マスタ
CREATE TABLE users (
	id       SERIAL       PRIMARY KEY,
	role     INTEGER      NOT NULL DEFAULT 2,
	name     VARCHAR(50)  NOT NULL,
	address  VARCHAR(255) NOT NULL,
	phone    VARCHAR(14)  NOT NULL,
	email    VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL
);
-- 資料カタログ：資料の書誌情報
CREATE TABLE material_catalogues (
	id             SERIAL       PRIMARY KEY,
	media_type     INTEGER      NOT NULL,
	ndc            INTEGER      NULL,
	title          VARCHAR(255) NOT NULL,
	author         VARCHAR(255) NULL,
	publisher      VARCHAR(100) NOT NULL,
	published_year INTEGER      NOT NULL
);
-- 資料台帳
CREATE TABLE material_ledgers (
	id            SERIAL PRIMARY KEY,
	catalogue_id INTEGER NOT NULL,
	call_number   VARCHAR(50) NOT NULL,
	status        INTEGER NULL,
	description   TEXT NULL
);
-- 貸出状況
CREATE TABLE loans (
	id SERIAL PRIMARY KEY,
	user_id   INTEGER NOT NULL,
	catalogue_id   INTEGER NOT NULL,
	loan_at   DATE NOT NULL,
	due_at    DATE NOT NULL,
	return_at DATE NULL
);
