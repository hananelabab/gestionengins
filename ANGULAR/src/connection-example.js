var mysql = require('mysql');

console.log('Get connection ...');

var conn = mysql.createConnection({
  database: 'db_engin',
  host: "localhost",
  user: "",
  password: ""
});

conn.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});