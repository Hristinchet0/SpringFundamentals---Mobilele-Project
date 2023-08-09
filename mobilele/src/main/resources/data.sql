INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES
    (1, 'admin@example.com', 'Admin', 'Adminov', null, 1, '0b52cf5b53921986334a5b5d676afabf93a98eaa8f7d0b0917dc129b4e8aceedf061d8a804ee4ab8'),
    (2, 'user@example.com', 'User', 'Userov', null, 1, '927f513ff8321d26da9033941a854bcbf48a4e4bb7adbd83e8053431f616d84c7adb960c56a36a22');

INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota'),
       (3, 'Mercedes'),
       (4, 'Audi'),
       (5, 'BMW'),
       (6, 'KTM');

INSERT INTO models (id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.auto-data.net/images/f110/Ford-Escort-VII-Hatch-GAL-AFL.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg/1280px-2020_Toyota_Yaris_Design_HEV_CVT_1.5_Front.jpg'),
       (4, 'E-Class', 'CAR', 2009, 2013, 3, 'https://cdn3.focus.bg/autodata/i/mercedes-benz/e-klasse/e-klasse-w212/large/6abc04f912744c16b9bea16852088c6a.jpg'),
       (5, 'A6', 'CAR', 2011, 2014, 4, 'https://cdn3.focus.bg/autodata/i/audi/a6/a6-avant-4g-c7/large/e85cf212e16539155f1d11b7202e8813.jpg'),
       (6, 'X5', 'CAR', 2010, 2013, 5, 'https://cdn3.focus.bg/autodata/i/bmw/x5/x5-e70-restyling/large/27022a539b6047a2cb52e1f6364e9039.jpg'),
       (7, '300 EXC', 'MOTORCYCLE', 2024, null, 6, 'https://motohouse.bg/wp-content/uploads/2022/04/ktm_300_exc_2024_motohouse.jpg');