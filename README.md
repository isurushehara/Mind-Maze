
# Mind Maze - Java Console Maze Game (v2)

Mind Maze is a text-based maze game built in Java using a layered structure (view, service, DAO, model) with MySQL persistence for users and scores.

This version adds:
- user registration and login
- score saving to database
- multiple maze options
- per-user score history

## Features

- Console menu system (main menu + user menu)
- Authentication:
   - register new users
   - login with username and password
   - SHA-256 password hashing
- Maze gameplay commands:
   - `go`
   - `turn left`
   - `turn right`
   - `where`
   - `exit`
- Score tracking:
   - number of commands used is recorded on win
   - score records stored in MySQL

## Tech Stack

- Java (JDK 8+)
- MySQL
- JDBC (MySQL Connector/J)

## Project Structure

```
src/
   dao/
      PlayerDAO.java
      ScoreDAO.java
      UserDAO.java
   database/
      DBConnection.java
   game/
      GameEngine.java
   main/
      Main.java
   maps/
      Maze1.java
      Maze2.java
      MazeFactory.java
   model/
      Direction.java
      Map.java
      Maze.java
      Player.java
      Score.java
      User.java
   service/
      GameService.java
      LoginService.java
      MovementService.java
      ScoreService.java
   util/
      Input.java
      PasswordUtil.java
   view/
      ConsoleView.java
```

## Database Setup

Create a MySQL database named `maze_game` and run:

```sql
CREATE DATABASE IF NOT EXISTS maze_game;
USE maze_game;

CREATE TABLE IF NOT EXISTS users (
      id INT AUTO_INCREMENT PRIMARY KEY,
      username VARCHAR(100) NOT NULL UNIQUE,
      password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS scores (
      id INT AUTO_INCREMENT PRIMARY KEY,
      user_id INT NOT NULL,
      maze_number INT NOT NULL,
      commands INT NOT NULL,
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
      FOREIGN KEY (user_id) REFERENCES users(id)
);
```

Default database credentials currently used in code:
- URL: `jdbc:mysql://localhost:3306/maze_game`
- USER: `your_username`
- PASSWORD: `your_password`

Update these in `src/database/DBConnection.java` if needed.

## Build and Run

From the project root:

1. Compile:

```bash
javac -d out -sourcepath src src/main/Main.java
```

2. Run:

```bash
java -cp out main.Main
```

If you get JDBC driver errors, add MySQL Connector/J to your classpath.

## Gameplay Notes

- Player starts at row `0`, column `4`, facing `NORTH`.
- Maze selection is available after login:
   - Maze 1 exit at `(9, 4)`
   - Maze 2 exit at `(9, 5)`
- Each successful move or turn increases command count.
- Winning saves score for the logged-in user.

## Known Limitations

- `maze_number` is currently saved as `1` after a win, even if Maze 2 is selected.
- Input handling for menu choices expects numeric input.

## Author

Developed by Isuru Shehara.
