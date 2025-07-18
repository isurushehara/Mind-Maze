
# 🧠 Mind Maze - Java Text-Based Maze Game

Welcome to **Mind Maze**, a simple yet engaging Java-based text adventure game where your mission is to escape a 10x10 maze (level 1) using directional commands. It’s a test of memory, logic, and spatial awareness.

## 🎮 Game Description

You are dropped at the entrance of a maze (eg: coordinates x:5, y:1). Your task is to escape by reaching the goal at **Scape Door** [eg: (x:5, y:10)], avoiding walls and finding the correct path using textual commands.

The maze is internally represented as a 10x10 grid where:
- `1` represents a **wall**
- `0` represents a **walkable path**

You will interact with the game using text commands to **move** and **turn** your character until you reach the exit.

## 🧾 How to Play

### ✅ Available Commands:
- `go` – Move forward in the current direction
- `turn right` – Turn 90° to the right
- `turn left` – Turn 90° to the left
- `where` – Show your current position and direction
- `exit` – Exit the game

### 🎯 Winning Condition:
Reach the goal cell at **(x:5, y:10)**. The game ends with a congratulatory message and the number of commands you used.

## 🚀 Getting Started

### Prerequisites:
- Java JDK 8 or higher
- Any IDE (e.g., IntelliJ, VS Code) or terminal with Java compiler

### 📦 Run the Game

1. Clone or download this repository
2. Compile the Java files:
   ```bash
   javac Main.java Action.java
   ```
3. Run the game:
   ```bash
   java Main
   ```
## 🗺️ Maze Level 1 Map Preview

Here's a visual of the internal maze grid (`1 = wall`, `0 = path`):

```
1 1 1 1 0 1 1 1 1 1  
1 0 1 0 0 0 1 0 0 1  
1 0 1 0 1 0 1 1 0 1  
1 0 0 0 1 1 1 0 0 1  
1 1 1 0 0 0 0 0 1 1  
1 0 0 1 1 1 1 0 1 1  
1 0 0 1 0 0 0 0 1 1  
1 0 1 1 0 1 1 0 1 1  
1 0 0 0 0 0 0 0 0 1  
1 1 1 1 0 1 1 1 1 1  
```

## 📂 Project Structure

```
.
├── Main.java       # Main game loop
└── Action.java     # Player actions and maze logic
```

## ✍️ Author

- Developed by Isuru Shehara.

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

Have fun escaping the Mind Maze!
