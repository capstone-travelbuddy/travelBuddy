DROP DATABASE IF EXISTS travelbuddy_db;

USE travelbuddy_db;

INSERT INTO city(description, name, state)
VALUES ('San Antonio is a major city in south-central Texas with a rich colonial heritage. The Alamo, an 18th-century Spanish mission preserved as a museum, marks an infamous 1836 battle for Texan independence from Mexico. Following the San Antonio River, the miles-long River Walk is a landmark pedestrian promenade lined with cafes and shops.',
        'San Antonio', 'Texas'),
       ('Austin is located in central Texas, at the boundary between the Texas Hill Country and the prairies of East Texas. Austin has abundant greenery and forestation with lakes and streams, and is surrounded by state parks. Austin is well-known for its support of freedom of expression. There is also active support of the arts and film, and over 200 live music venues.',
        'Austin', 'Texas'),
       ('As the ninth-largest city and part of the fourth-largest metropolitan area in the nation, Dallas covers approximately 343 square miles and has a population of 1,241,162. The ultra modern and sophisticated city attracts worldwide travelers, making the area the No. 1 visitor and leisure destination in Texas. provident ex.',
        'Dallas', 'Texas');

INSERT INTO category(description, name)
VALUES ('Coffee is booming in San Antonio. While the family at What’s Brewing? Coffee Roasters has been roasting in the Alamo City since 1981, it’s only been in recent years that locals have had their choice of high-quality roasts from dozens of local roasters and cafes.',
        'coffee shop'),
       ('San Antonio’s landscape is a mecca for micro-brew fans and is only getting better. For those looking at what the city has to offer, taking a weekend to map out a craft beer jaunt from the Blue Star Arts Complex to Pearl Brewery, provides a number of amazing craft experiences.',
        'brewery'),
       ('Our restaurants’ culinary traditions blend with new and traditional homegrown talent for a food and drink scene bursting with flavor and fun. We are serving up more than just delicious food at our restaurants. We are sharing experiences, traditions and culture – are you ready to eat!',
        'eatery');

#     https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQl_QEd-Vbjc&#45;&#45;fCciZgMnXQmXiXOuc3mHi1w&usqp=CAU
#     https://austin.com/wp-content/uploads/2020/08/Austin-Lady-Bird-Lake-scaled-e1598026929283.jpeg.jpeg
#     https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQj2wuHnHVOw3VSowMOPAJgvnjTQ2olDC4cvw&usqp=CAU