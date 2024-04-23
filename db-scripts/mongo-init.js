db = connect('mongodb://localhost/notification');

db.createUser({
    user: "noti",
    pwd: "noti",
    roles: [
        {
            role: "readWrite",
            db: "notification"
        }
    ]
});