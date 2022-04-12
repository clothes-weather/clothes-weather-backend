db = db.getSiblingDB('clothes_weather_db');

db.createCollection('clothes_weather_collection');

db.createUser(
    {
        user: "n.lvov",
        pwd: "1705",
        roles: [
            {
                role: "readWrite",
                db: "clothes_weather_db"
            }
        ]
    }
);