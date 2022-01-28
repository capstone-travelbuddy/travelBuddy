DROP DATABASE IF EXISTS travelbuddy_db;

USE travelbuddy_db;

INSERT INTO city(description, name, state, city_image_id)
VALUES ('San Antonio is a major city in south-central Texas with a rich colonial heritage. The Alamo, an 18th-century Spanish mission preserved as a museum, marks an infamous 1836 battle for Texan independence from Mexico. Following the San Antonio River, the miles-long River Walk is a landmark pedestrian promenade lined with cafes and shops.',
        'San Antonio', 'Texas', 1),
       ('Austin is located in central Texas, at the boundary between the Texas Hill Country and the prairies of East Texas. Austin has abundant greenery and forestation with lakes and streams, and is surrounded by state parks. Austin is well-known for its support of freedom of expression. There is also active support of the arts and film, and over 200 live music venues.',
        'Austin', 'Texas', 1),
       ('As the ninth-largest city and part of the fourth-largest metropolitan area in the nation, Dallas covers approximately 343 square miles and has a population of 1,241,162. The ultra modern and sophisticated city attracts worldwide travelers, making the area the No. 1 visitor and leisure destination in Texas. provident ex.',
        'Dallas', 'Texas', 1);

INSERT INTO category(name, description, type, category_image_id)
VALUES ('coffee shop', 'coffee shop', 'coffee', 1),
       ('brewery', 'brewery', 'brews', 1),
       ('eatery', 'eatery', 'eats', 1);

INSERT INTO shops(name, address, category_id, city_id, description, website, socialurl)
VALUES ('Merit Coffee Co.', '5903 Broadway, San Antonio, TX 78209', 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.', 'https://meritcoffee.com/', 'https://www.instagram.com/meritcoffee/'),
       ('Cafe Azteca', '106 Jefferson, San Antonio, TX 78205', 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.', 'https://www.facebook.com/Cafe-Azteca-572592856241890/?ref=page_internal', 'https://www.instagram.com/cafe.azteca/'),
       ('Halcyon Southtown', '1414 S Alamo St, San Antonio, TX 78210', 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.', 'http://halcyoncoffeebar.com/', 'https://www.instagram.com/halcyonsouthtown/'),
       ('La Panaderia', 'Location 301 E. Houston St.
San Antonio, TX 78205', 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.', 'https://lapanaderia.com/', 'https://www.instagram.com/lapanaderia/');

INSERT INTO shops(name, category_id, city_id, description)
VALUES ('Bosch\'s Brewery', 2, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.');

INSERT INTO reviews(created, description, rating, shop_id, user_id)
VALUES (CURRENT_DATE,
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium atque dignissimos facilis laboriosam nemo nisi quis quos, ratione tempora tenetur. Adipisci architecto at doloremque earum illo ipsam provident sunt unde.',
        5, 1, 1),
       (CURRENT_DATE,
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium atque dignissimos facilis laboriosam nemo nisi quis quos, ratione tempora tenetur. Adipisci architecto at doloremque earum illo ipsam provident sunt unde.',
        3, 1, 1),
       (CURRENT_DATE,
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium atque dignissimos facilis laboriosam nemo nisi quis quos, ratione tempora tenetur. Adipisci architecto at doloremque earum illo ipsam provident sunt unde.',
        1, 1, 1);

#     https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQl_QEd-Vbjc&#45;&#45;fCciZgMnXQmXiXOuc3mHi1w&usqp=CAU
#     https://austin.com/wp-content/uploads/2020/08/Austin-Lady-Bird-Lake-scaled-e1598026929283.jpeg.jpeg
#     https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQj2wuHnHVOw3VSowMOPAJgvnjTQ2olDC4cvw&usqp=CAU