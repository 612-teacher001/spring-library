DELETE FROM ndc_master;
DELETE FROM role_master;

-- 日本十進分類マスタ
INSERT INTO ndc_master VALUES 
    (0, '総記'), (1, '哲学'), (2, '歴史'), (3, ' 社会科学'), (4, '自然科学'), 
    (5, '技術・工学'), (6, '産業'), (7, '芸術'), (8, '言語'), (9, '地理・伝記');

-- 権限マスタ
INSERT INTO role_master (name) VALUES ('システム管理者'), ('一般利用者');

-- 媒体マスタ
INSERT INTO media_master (name) VALUES ('書籍'), ('雑誌（定期刊行物）'), ('光学媒体（CD/DVD）');

-- 資料状況マスタ
INSERT INTO status_master (name) VALUES ('利用可'), ('貸出不可'), ('廃棄'); 

-- 利用者マスタ
INSERT INTO users (role, name, address, phone, email, password) VALUES
    (1, '山東京伝', '東京都中央区銀座', '03-0000-0000', 'kyoden@aaa.com', 'himitu'),
    (1, '平賀源内', '東京都千代田区神田鍛冶町', '03-0000-0000', 'genai@aaa.com', 'himitu'),
    (2, '太田南畝', '東京都新宿区牛込中町', '03-0000-0000', 'nanbo@aaa.com', 'himitu'),
    (2, '太田蜀山人', '大阪市中央区北浜', '06-0000-0000', 'shokusanjin@aaa.com', 'himitu'),
    (2, '四方赤良', '東京都台東区根岸', '03-0000-0000', 'yomo@aaa.com', 'himitu');

-- 資料カタログ
INSERT INTO material_catalogues (media_type, ndc, title, author, publisher, published_year) VALUES
    (1, 4, 'タイムマシーンの乗り方', 'ライター集団魁', '講談社', 2024),
    (1, 5, 'Javaの基本', 'ふわふわデバック団', '翔泳社', 2024),
    (1, 5, '実践UML', 'ふわふわデバック団', 'オライリージャパン', 2024),
    (1, 6, '料理をおいしくもっとおいしく！', '山田酸辣湯', 'オライリージャパン', 2024),
    (1, 6, 'みんなのいちご大福', 'シャトレーゼ', 'オライリージャパン', 2024);

