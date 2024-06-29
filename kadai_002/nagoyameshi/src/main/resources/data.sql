-- usersテーブル --
INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (1, 3, '山田 太郎', 'ヤマダ タロウ', '123-4567', '東京都新宿区西新宿1-1-1', '03-1234-5678', '1985-05-15', 1, 'taro.yamada@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', true);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (2, 2, '佐藤 花子', 'サトウ ハナコ', '234-5678', '神奈川県横浜市中区山下町2-2-2', '045-2345-6789', '1990-06-20', 2, 'hanako.sato@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', true);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (3, 1, '鈴木 次郎', 'スズキ ジロウ', '345-6789', '大阪府大阪市北区梅田3-3-3', '06-3456-7890', '1978-07-25', 3, 'jiro.suzuki@example.com', 'password345', true);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (4, 1, '高橋 美咲', 'タカハシ ミサキ', '456-7890', '愛知県名古屋市中村区名駅4-4-4', '052-4567-8901', '1988-08-30', 4, 'misaki.takahashi@example.com', 'password456', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (5, 1, '田中 一郎', 'タナカ イチロウ', '567-8901', '北海道札幌市中央区北五条西5-5-5', '011-5678-9012', '1982-09-05', 5, 'ichiro.tanaka@example.com', 'password567',false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (6, 1, '渡辺 香織', 'ワタナベ カオリ', '678-9012', '福岡県福岡市博多区博多駅前6-6-6', '092-6789-0123', '1992-10-10', 6, 'kaori.watanabe@example.com', 'password678', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (7, 1, '伊藤 健', 'イトウ ケン', '789-0123', '広島県広島市中区紙屋町7-7-7', '082-7890-1234', '1987-11-15', 7, 'ken.ito@example.com', 'password789', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (8, 1, '松本 涼子', 'マツモト リョウコ', '890-1234', '宮城県仙台市青葉区中央8-8-8', '022-8901-2345', '1995-12-20', 8, 'ryoko.matsumoto@example.com', 'password890', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (9, 1, '中村 修', 'ナカムラ オサム', '901-2345', '埼玉県さいたま市大宮区桜木町9-9-9', '048-9012-3456', '1983-01-25', 9, 'osamu.nakamura@example.com', 'password901', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (10, 1, '小林 彩', 'コバヤシ アヤ', '012-3456', '千葉県千葉市中央区富士見1-1-1', '043-0123-4567', '1998-02-05', 10, 'aya.kobayashi@example.com', 'password012', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (11, 1, '加藤 剛', 'カトウ ツヨシ', '123-4567', '京都府京都市中京区烏丸通御池1-1-1', '075-1234-5678', '1986-03-15', 1, 'tsuyoshi.kato@example.com', 'password1234', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (12, 1, '吉田 奈美', 'ヨシダ ナミ', '234-5678', '兵庫県神戸市中央区三宮町2-2-2', '078-2345-6789', '1993-04-20', 2, 'nami.yoshida@example.com', 'password2345', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (13, 1, '山本 悠', 'ヤマモト ユウ', '345-6789', '福島県福島市置賜町3-3-3', '024-3456-7890', '1981-05-25', 3, 'yu.yamamoto@example.com', 'password3456', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (14, 1, '池田 美樹', 'イケダ ミキ', '456-7890', '長野県長野市鶴賀4-4-4', '026-4567-8901', '1989-06-30', 4, 'miki.ikeda@example.com', 'password4567', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (15, 1, '森 直樹', 'モリ ナオキ', '567-8901', '新潟県新潟市中央区万代5-5-5', '025-5678-9012', '1984-07-05', 5, 'naoki.mori@example.com', 'password5678', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (16, 1, '林 さくら', 'ハヤシ サクラ', '678-9012', '岐阜県岐阜市神田町6-6-6', '058-6789-0123', '1991-08-10', 6, 'sakura.hayashi@example.com', 'password6789', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (17, 1, '清水 健太', 'シミズ ケンタ', '789-0123', '静岡県静岡市葵区常磐町7-7-7', '054-7890-1234', '1987-09-15', 7, 'kenta.shimizu@example.com', 'password7890', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (18, 1, '山崎 優子', 'ヤマザキ ユウコ', '890-1234', '群馬県前橋市本町8-8-8', '027-8901-2345', '1992-10-20', 8, 'yuko.yamazaki@example.com', 'password8901', false);

INSERT IGNORE INTO users (id, role_id, name, ruby, post_number, address, phone_number, birthday, job_id, email, password, enabled) 
VALUES (19, 1, '松田 和也', 'マツダ カズヤ', '901-2345', '青森県青森市古川9-9-9', '017-9012-3456', '1983-11-25', 9, 'kazuya.matsuda@example.com', 'password9012', false);

-- restaurantsテーブル --
INSERT IGNORE INTO restaurants (id, category_id, name, image_name, description, price, post_number, address, phone_number, open_time, close_time, capacity) VALUES
(1, 1, '和食 旬彩', 'restaurant01.jpg', '季節の食材を使用した伝統的な和食を提供するレストラン。落ち着いた雰囲気で、家族連れにも最適です。', 9000, '456-7890', '京都府京都市中京区祇園4-4-4', '075-4567-8901', '11:30', '21:30', 35),
(2, 2, '鉄板焼き 炎', 'restaurant02.jpg', '新鮮な素材を目の前で焼き上げるライブ感溢れる鉄板焼き店。特別な日のディナーに最適。', 7500, '567-8901', '福岡県福岡市中央区天神5-5-5', '092-5678-9012', '12:00', '22:30', 25),
(3, 3, 'フレンチ ルヴァン', 'restaurant03.jpg', '本格的なフレンチ料理を堪能できるレストラン。厳選されたワインと共に優雅なひとときを。', 12000, '678-9012', '北海道札幌市中央区大通り6-6-6', '011-6789-0123', '10:30', '23:00', 40),
(4, 1, '寿司 さくら', 'restaurant01.jpg', '新鮮な魚介を使った本格寿司を提供する寿司店。職人技が光る一品一品をお楽しみください。', 11000, '789-0123', '神奈川県横浜市中区山下町7-7-7', '045-7890-1234', '11:00', '21:00', 30),
(5, 2, '韓国料理 華', 'restaurant02.jpg', '本場韓国の味を再現した韓国料理店。豊富なメニューでお客様をお迎えします。', 8500, '890-1234', '広島県広島市中区紙屋町8-8-8', '082-8901-2345', '12:00', '22:30', 35),
(6, 3, 'スペイン料理 パラダイス', 'restaurant03.jpg', 'スペイン直輸入の食材を使用した本格スペイン料理店。陽気な雰囲気で楽しいひとときを。', 9500, '901-2345', '宮城県仙台市青葉区中央9-9-9', '022-9012-3456', '11:30', '22:30', 25),
(7, 1, '海鮮 かに家', 'restaurant01.jpg', '新鮮なカニ料理が自慢の海鮮レストラン。贅沢なひとときをお過ごしください。', 13000, '012-3456', '千葉県千葉市中央区市場1-1-1', '043-0123-4567', '10:00', '20:00', 20),
(8, 2, '天ぷら 花月', 'restaurant02.jpg', 'サクサクの天ぷらを提供する専門店。新鮮な素材を使った天ぷらをお楽しみください。', 7800, '123-4567', '岐阜県岐阜市柳ヶ瀬2-2-2', '058-1234-5678', '11:30', '21:30', 30),
(9, 3, 'イタリアン デルソーレ', 'restaurant03.jpg', '本格的なイタリアン料理を楽しめるレストラン。カジュアルな雰囲気で気軽にご利用いただけます。', 7000, '234-5678', '群馬県前橋市本町3-3-3', '027-2345-6789', '12:00', '22:00', 35),
(10, 1, '割烹 菊', 'restaurant01.jpg', '伝統的な割烹料理を提供する高級店。おもてなしの心を大切にしています。', 9500, '345-6789', '静岡県静岡市葵区駿河3-3-3', '054-3456-7890', '11:00', '21:30', 25),
(11, 2, '鉄板焼き 竹', 'restaurant02.jpg', '上質な和牛を目の前で焼き上げる鉄板焼き店。特別な日の贅沢にぴったりです。', 8200, '456-7890', '埼玉県さいたま市大宮区桜木町4-4-4', '048-4567-8901', '10:30', '22:00', 40),
(12, 3, 'フレンチ エクレール', 'restaurant03.jpg', '現代風のフレンチ料理を提供するおしゃれなレストラン。デザートも絶品です。', 11000, '567-8901', '新潟県新潟市中央区万代5-5-5', '025-5678-9012', '12:00', '23:00', 30),
(13, 1, '寿司 まぐろや', 'restaurant01.jpg', '新鮮なマグロを使った寿司が自慢の寿司店。寿司好きにはたまらない一品が揃っています。', 11500, '678-9012', '青森県青森市古川6-6-6', '017-6789-0123', '11:00', '21:00', 35),
(14, 2, '焼肉 牛若', 'restaurant02.jpg', '厳選された和牛を使用した焼肉店。特製のタレで味わうお肉は絶品です。', 8500, '789-0123', '岡山県岡山市北区中山7-7-7', '086-7890-1234', '10:30', '22:30', 25),
(15, 3, 'スペイン料理 リベルタ', 'restaurant03.jpg', 'スペイン料理の伝統とモダンを融合させたレストラン。タパスからパエリアまで幅広く楽しめます。', 9800, '890-1234', '長崎県長崎市浜町8-8-8', '095-8901-2345', '12:00', '22:00', 40),
(16, 1, '海鮮 旬', 'restaurant01.jpg', '季節の新鮮な海鮮料理が自慢のレストラン。特にお刺身が人気です。', 12500, '901-2345', '熊本県熊本市中央区水前寺9-9-9', '096-9012-3456', '11:30', '21:30', 30),
(17, 2, '天ぷら 虎屋', 'restaurant02.jpg', 'サクサクの天ぷらを提供する専門店。新鮮な素材を使った天ぷらをお楽しみください。', 7800, '012-3456', '静岡県浜松市中区中央1-1-1', '053-0123-4567', '10:00', '20:30', 25),
(18, 3, 'イタリアン テラッツォ', 'restaurant03.jpg', '本格的なイタリアン料理を楽しめるレストラン。カジュアルな雰囲気で気軽にご利用いただけます。', 7200, '123-4567', '愛媛県松山市道後2-2-2', '089-1234-5678', '12:00', '22:00', 35),
(19, 1, '割烹 あおい', 'restaurant01.jpg', '伝統的な割烹料理を提供する高級店。おもてなしの心を大切にしています。', 10200, '234-5678', '石川県金沢市広坂3-3-3', '076-2345-6789', '11:00', '21:00', 20),
(20, 2, '韓国料理 明洞', 'restaurant02.jpg', '本場韓国の味を再現した韓国料理店。豊富なメニューでお客様をお迎えします。', 8700, '345-6789', '鹿児島県鹿児島市中央4-4-4', '099-3456-7890', '12:00', '23:00', 30);

-- reviewsテーブル --
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (1, 1, 1, 4, '部屋が綺麗で、快適に過ごせました。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (2, 2, 1, 4, 'アクセスが良く、観光に最適でした。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (3, 3, 1, 5, 'スタッフが新設で、気持ちよく滞在できました。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (4, 4, 1, 4, '駅から近く、便利でした。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (5, 5, 1, 5, '周辺の飲食店が充実していて、楽しめました。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (6, 6, 1, 4, '宿泊費が手軽でコストパフォーマンスが良かったです。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (7, 7, 1, 3, '静かな環境でゆっくり休めました。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (8, 8, 1, 4, '施設内の設備が充実していました。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (9, 9, 1, 5, 'Wi-Fiが快適で助かりました。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (10, 10, 1, 4, '清潔感があり、気持ちよく滞在できました。');
INSERT IGNORE INTO reviews (id, user_id, restaurant_id, review_score,  review_comment) VALUES (11, 11, 1, 1,  '期待が大きかっただけに残念でした。'); 

-- categoriesテーブル --
INSERT IGNORE INTO categories (id, name) VALUES (1, '和食');
INSERT IGNORE INTO categories (id, name) VALUES (2, '中華料理');
INSERT IGNORE INTO categories (id, name) VALUES (3, 'イタリアン');
INSERT IGNORE INTO categories (id, name) VALUES (4, 'フレンチ');
INSERT IGNORE INTO categories (id, name) VALUES (5, '焼肉');
INSERT IGNORE INTO categories (id, name) VALUES (6, '寿司');
INSERT IGNORE INTO categories (id, name) VALUES (7, '鉄板焼き');
INSERT IGNORE INTO categories (id, name) VALUES (8, '居酒屋');
INSERT IGNORE INTO categories (id, name) VALUES (9, 'ラーメン');
INSERT IGNORE INTO categories (id, name) VALUES (10, 'カレー');
INSERT IGNORE INTO categories (id, name) VALUES (11, 'ステーキ');
INSERT IGNORE INTO categories (id, name) VALUES (12, 'ハンバーガー');
INSERT IGNORE INTO categories (id, name) VALUES (13, 'パスタ');
INSERT IGNORE INTO categories (id, name) VALUES (14, '鍋料理');
INSERT IGNORE INTO categories (id, name) VALUES (15, 'お好み焼き');
-- rolesテーブル --
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'ROLE_PREMIUM');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');

-- jobsテーブル --
INSERT IGNORE INTO jobs (id, name) VALUES (1, 'エンジニア');
INSERT IGNORE INTO jobs (id, name) VALUES (2, 'デザイナー');
INSERT IGNORE INTO jobs (id, name) VALUES (3, '営業');
INSERT IGNORE INTO jobs (id, name) VALUES (4, 'マーケティング');
INSERT IGNORE INTO jobs (id, name) VALUES (5, '教師');
INSERT IGNORE INTO jobs (id, name) VALUES (6, '看護師');
INSERT IGNORE INTO jobs (id, name) VALUES (7, '弁護士');
INSERT IGNORE INTO jobs (id, name) VALUES (8, '公務員');
INSERT IGNORE INTO jobs (id, name) VALUES (9, '医師');
INSERT IGNORE INTO jobs (id, name) VALUES (10, 'その他');

