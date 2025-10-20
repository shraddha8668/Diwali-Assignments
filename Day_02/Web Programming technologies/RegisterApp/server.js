const express = require("express");
const mysql = require("mysql");
const bodyParser = require("body-parser");
const cors = require("cors");

const app = express();
const port = 3000;

app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));


const db = mysql.createConnection({
  host: "localhost",
  user: "root",        
  password: "Shraddha@8668",         
  database: "userdb"
});

db.connect((err) => {
  if (err) {
    console.error("Database connection failed:", err);
    return;
  }
  console.log("Connected to MySQL Database");
});


app.get("/", (req, res) => {
  res.send("Welcome to User Registration API");
});


app.post("/register", (req, res) => {
  const { firstname, lastname, email, userid, password } = req.body;

  if (!firstname || !lastname || !email || !userid || !password) {
    return res.status(400).json({ error: "All fields are required" });
  }

  const sql = "INSERT INTO users (firstname, lastname, email, userid, password) VALUES (?, ?, ?, ?, ?)";
  db.query(sql, [firstname, lastname, email, userid, password], (err, result) => {
    if (err) {
      console.error("Error inserting data:", err);
      return res.status(500).json({ error: "Database insert failed" });
    }
    res.status(200).json({ message: " Registration successful!" });
  });
});


app.listen(port, () => {
  console.log(`Server running on http://localhost:${port}`);
});
