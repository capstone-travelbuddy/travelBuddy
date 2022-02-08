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
VALUES ('Coffee Shop', 'Coffee Shop', 'coffee', 1),
       ('Brewery', 'Brewery', 'brews', 1),
       ('Eatery', 'Eatery', 'eats', 1);

INSERT INTO shops(name, address, category_id, city_id, description, website, socialurl)
VALUES ('Merit Coffee Co.', '5903 Broadway, San Antonio, TX 78209', 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.',
        'https://meritcoffee.com/', 'https://www.instagram.com/meritcoffee/'),
       ('Cafe Azteca', '106 Jefferson, San Antonio, TX 78205', 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.',
        'https://www.facebook.com/Cafe-Azteca-572592856241890/?ref=page_internal',
        'https://www.instagram.com/cafe.azteca/'),
       ('Halcyon Southtown', '1414 S Alamo St, San Antonio, TX 78210', 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.',
        'http://halcyoncoffeebar.com/', 'https://www.instagram.com/halcyonsouthtown/'),
       ('La Panaderia', 'Location 301 E. Houston St.
San Antonio, TX 78205', 1, 1,
        'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Veniam quidem eaque ut eveniet aut quis rerum. Asperiores accusamus harum ducimus velit odit ut. Saepe, iste optio laudantium sed aliquam sequi.',
        'https://lapanaderia.com/', 'https://www.instagram.com/lapanaderia/');

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

INSERT INTO shops(name, address, category_id, city_id, description, website, socialurl)
VALUES ('Sip Brew Bar & Eatery', '160 E Houston St, San Antonio, TX 78205', 1, 1,
        'Light-filled coffee shop serving espresso drinks, baked goods & sandwiches amid modern decor.',
        'https://www.sipbrewbar.com', 'https://www.instagram.com/sipbrewbar/?hl=en'),
       ('Rosella Coffee', '293 E Jones Ave Ste 101, San Antonio, TX 78215', 1, 1, '
Espresso drinks, snacks, beer & wine served in industrial-chic digs with free WiFi & patio seats.',
        'https://www.rosellacoffee.com', 'https://www.instagram.com/rosella_satx/'),
       ('What''s Brewing?', '138 W Rhapsody Dr, San Antonio, TX 78216', 1, 1,
        'Longtime, family-owned gourmet coffee provider offers specialty roasted-to-order beans & blends.',
        'https://www.sacoffeeroasters.com', 'https://www.instagram.com/whatsbrewingsa/'),
       ('Commonwealth Coffeehouse
', '118 Davis Ct, San Antonio, TX 78209', 1, 1,
        'Homemade pastries, French cafe fare & espresso drinks are the draw at this stylish, laid-back venue.',
        'http://commonwealthcoffeehouse.com', 'https://instagram.com/commonwealth_coffeehouse/');

INSERT INTO shops(name, address, category_id, city_id, description, website, socialurl)
VALUES ('Ranger Creek', '4834 Whirlwind Dr, San Antonio, TX 78217', 2, 1,
        'Industrial brewstillery offers a wide selection of microbrews & craft whiskies, with Saturday tours.',
        'https://drinkrangercreek.com', 'https://www.instagram.com/rangercreek/'),
       ('Alamo Beer Company', '202 Lamar St, San Antonio, TX 78202', 2, 1,
        'Large indoor/outdoor space with picnic tables & cornhole featuring craft draft beer & live music.',
        'https://www.alamobeer.com', 'https://www.instagram.com/alamobeerco/'),
       ('Busted Sandal Brewing Company', '7114 Oaklawn Dr, San Antonio, TX 78229', 2, 1,
        'Artisanal beers from local ingredients, with pours from the on-site tap room 4 nights a week.',
        'http://www.bustedsandalbrewing.com', 'https://www.instagram.com/bustedsandalbrewing/'),
       ('Freetail Brewing Co.', '4035 N Loop 1604 W, San Antonio, TX 78257', 2, 1,
        'Small-batch craft beers, pizza, TVs & scenic views are among the draws to this bat-themed brewpub.',
        'https://www.freetailbrewing.com', 'https://instagram.com/freetailbrewing');

INSERT INTO shops(name, address, category_id, city_id, description, website, socialurl)
VALUES ('Biga on the Banks', '203 S Saint Marys St, San Antonio, TX 78205', 3, 1,
        'Chic River Walk eatery with adventurous New American fare, worldly wines & an ever-changing menu.',
        'https://biga.com', 'https://www.instagram.com/bigaonthebanks/?hl=en'),
       ('Pollos Asados Los Nortenos', '4642 Rigsby Ave, San Antonio, TX 78222', 3, 1,
        'Low-key option offering a variety of traditional Mexican chow in a casual environment.',
        'http://polloslosnortenos.com/', 'https://www.instagram.com/polloslosnortenos/'),
       ('Smoke Shack', '3714 Broadway, San Antonio, TX 78209', 3, 1,
        'Down-home mobile smoke shack with picnic table seating earns buzz for its classic BBQ meals & sides.',
        'http://www.smokeshacksa.com/', 'https://www.instagram.com/smokeshack'),
       ('Cappy''s Restaurant', '5011 Broadway, San Antonio, TX 78209', 3, 1,
        'New American-Eclectic fine dining fare presented in an upscale casual space with warm wood tones.',
        'http://www.cappysrestaurant.com/', 'http://instagram.com/cappysrestaurant');

INSERT INTO shops(name, address, category_id, city_id, description, website, socialurl)
VALUES ('Mozart''s Coffee Roasters', '3825 Lake Austin Blvd, Austin, TX 78703', 1, 2,
        'Beans flame-roasted on-site, plus bakery goods, frequent live music & patio seating on Lake Austin.',
        'http://mozartscoffee.com/', 'https://www.instagram.com/mozartscoffee'),
       ('Cuvee Coffee Bar', '2000 E 6th St, Austin, TX 78702', 1, 2,
        'Cafe & retail space serving up pour-over, espresso & cold draft coffees, plus craft beers on tap.',
        'http://cuveecoffee.com/', 'https://www.instagram.com/cuveecoffee'),
       ('Epoch Coffee', '221 W N Loop Blvd, Austin, TX 78751', 1, 2,
        '24/7 coffee shop vending espresso drinks, sweets & pizza from East Side Pies in open, casual space.',
        'http://www.epochcoffee.com/', 'https://instagram.com/epochcoffee/'),
       ('Cherrywood Coffeehouse', '1400 E 38th 1/2 St, Austin, TX 78722', 1, 2,
        'Eclectic eats from tacos to muffalettas in an art-adorned counter-serve cafe, plus free yoga.',
        'http://www.cherrywoodcoffeehouse.com/', 'https://www.instagram.com/cherrywood_coffeehouse/');

INSERT INTO shops(name, address, category_id, city_id, description, website, socialurl)
VALUES ('Lazarus Brewing Co.', '1902 E 6th St, Austin, TX 78702', 2, 2,
        'Cozy brewery for house beers sold only on-premise, plus root beer, kombucha, espresso & house tacos.',
        'http://www.lazarusbrewing.com/', 'http://instagram.com/lazarusbrewing'),
       ('Draught House Pub & Brewery', '4112 Medical Pkwy, Austin, TX 78756', 2, 2,
        'This hip brewpub''s vast craft-beer menu includes a few made on-site, plus food-truck grub outside.',
        'http://www.draughthouse.com/', 'https://www.instagram.com/draughthouse'),
       ('The Austin Beer Garden Brewing Co.', '1305 W Oltorf St, Austin, TX 78704', 2, 2,
        'Warehouselike beer garden matching house microbrews with pub bites such as pizza & sandwiches.',
        'http://www.theabgb.com/', 'https://instagram.com/theabgb/'),
       ('The Brewtorium', '6015 Dillard Cir A, Austin, TX 78752', 2, 2,
        'Brewery, restaurant & beer garden with German-style beers plus pizza, mac & cheese & pub grub.',
        'http://thebrewtorium.com/', 'https://www.instagram.com/thebrewtorium');

INSERT INTO shops(name, address, category_id, city_id, description, website, socialurl)
VALUES ('Jack Allen''s Kitchen Oak Hill', '7720 State Hwy 71 West, Austin, TX 78735', 3, 2,
        'Lively restaurant & bar for upscale Southwestern cuisine made with ingredients from local farms.',
        'http://www.jackallenskitchen.com/', 'https://www.instagram.com/jackallenskitchen'),
       ('Salty Sow', '1917 Manor Rd, Austin, TX 78722', 3, 2,
        'Braised, poached & stewed dishes, plus cocktails & craft brews, are served in a laid-back setting.',
        'http://www.saltysow.com/', 'https://www.instagram.com/saltysow/'),
       ('True Food Kitchen', '222 West Ave Ste HR100, Austin, TX 78701', 3, 2,
        'Relaxed, eco-chic restaurant serving health-conscious fare, including vegan options, plus cocktails.',
        'https://www.truefoodkitchen.com/locations/austin/', 'https://www.instagram.com/livetruefood'),
       ('The Peached Tortilla', '5520 Burnet Rd #100, Austin, TX 78756', 3, 2,
        'Casual eatery with retro flair known for banh mi tacos & other Asian-fusion fare & a whiskey menu.',
        'https://thepeachedtortilla.com', 'http://instagram.com/peachedtortilla');

INSERT INTO shops(name, address, category_id, city_id, description, website, socialurl)
VALUES ('')

#     https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQl_QEd-Vbjc&#45;&#45;fCciZgMnXQmXiXOuc3mHi1w&usqp=CAU
#     https://austin.com/wp-content/uploads/2020/08/Austin-Lady-Bird-Lake-scaled-e1598026929283.jpeg.jpeg
#     https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQj2wuHnHVOw3VSowMOPAJgvnjTQ2olDC4cvw&usqp=CAU