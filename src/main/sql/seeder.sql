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

INSERT INTO shops(name, category_id, city_id, shop_image_id, description)
VALUES ('Merit Coffee Co.', 1, 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.'),
       ('Cafe Azteca', 1, 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.'),
       ('Halcyon Southtown', 1, 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.'),
       ('La Panaderia', 1, 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.');

#     https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQl_QEd-Vbjc&#45;&#45;fCciZgMnXQmXiXOuc3mHi1w&usqp=CAU
#     https://austin.com/wp-content/uploads/2020/08/Austin-Lady-Bird-Lake-scaled-e1598026929283.jpeg.jpeg
#     https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQj2wuHnHVOw3VSowMOPAJgvnjTQ2olDC4cvw&usqp=CAU