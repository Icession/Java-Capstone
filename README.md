# 🎯 Number Guesser – Capstone Project

**Number Guesser**, a Java-based game that challenges the player to guess a randomly generated number between 1 and 100. This project was designed with full Object-Oriented Programming principles in mind, featuring a neat and responsive graphical user interface, and a modular design that can easily scale into other types of guessing games.



## 🔹 Classes and Objects

This project is structured around multiple classes, each with a single properties. The `NumberGuesser` class handles the GUI using `JFrame`, while the `NumberGame` class handles the game logic. `NumberGame` inherits from an abstract class `Game`, which defines common methods. A separate `Score` class manages file operations. Each class utilizes fields and methods appropriately to encapsulate and operate on the necessary data, promoting a clean and readable codebase.



## 🔹 Class Diagram

The class diagram provides a visual breakdown of the system architecture. It includes the `Game` abstract class, its concrete subclass `NumberGame`, the GUI class `NumberGuesser`, and the `Score` class responsible for file handling. Each class shows its fields and methods to represent the structure and relationships accurately. This diagram ensures that the implementation aligns with object-oriented principles and offers a clear path for future extensions or modifications.

![image](https://github.com/user-attachments/assets/e4df3a28-29e0-4873-9594-5c2d40284872)



## 🔹 Four OOP Principles

### 🔸 Abstraction
The abstract class `Game` defines general behavior like `resetGame()` and `getAttempts()`, hiding the implementation details from users. This allows `NumberGame` to extend and implement these methods, focusing on game-specific logic while abstracting common behavior.

`abstract class Game {
    protected int attempts;
    public abstract void resetGame();
    public abstract int getAttempts();
}`

### 🔸 Encapsulation
Fields such as `targetNumber`, `attempts`, `min` etc.  are private, and access to them is controlled via public methods like `checkGuess()`. This protects the internal state of the objects and prevents unintended interference from outside classes. This ensures the users cannot get a hold of the code to cheat on the game.

public class NumberGame extends Game{
    private int targetNumber;
    private int attempts;
    private int min;
    private int max;  
    private Random random = new Random();


    public NumberGame(int attempts, int min, int max){
        this.attempts = attempts;
        this.min = min;
        this.max = max;
        generateNum();
    }
    

    public void generateNum(){
        targetNumber = random.nextInt(max - min + 1) + min;
    }

    String checkGuess(int guess){
        attempts++;
        if(guess < targetNumber) return "Too low!";
        else if (guess > targetNumber) return "Too high!";
        else if(guess == targetNumber){
             Score score = new Score();
            score.countScore(attempts);
            return "You guessed the number!";
        } else {
            return "Invalid guess";
        }
    }
    @Override
    public int getAttempts(){
        return attempts;
    }

    @Override
    public void resetGame() {
        attempts = 0;
        generateNum();
    }
}


### 🔸 Inheritance
`NumberGame` inherits from the `Game` abstract class and overrides its methods to implement the logic for a specific game. This reuse of functionality demonstrates inheritance and makes the design more scalable and maintainable.

public class NumberGame extends Game{


}

### 🔸 Polymorphism
Through method overriding, polymorphism is achieved. The `Game` reference can point to any of its subclasses (like `NumberGame`), and the overridden methods will execute according to the actual object type at runtime, enabling flexible and dynamic behavior.

@Override
    public int getAttempts(){
        return attempts;
    }

    @Override
    public void resetGame() {
        attempts = 0;
        generateNum();
    }

## 🔹 Exception Handling

Robust exception handling is implemented using `try-catch` blocks. The program safely handles user input errors, such as entering non-numeric values, by catching `NumberFormatException` and displaying a user-friendly message via `JOptionPane`. This ensures the application remains stable and user-centric, even with unexpected inputs. The code could easily be extended to include custom exceptions for advanced error tracking.

![image](https://github.com/user-attachments/assets/0d0b4a8e-a1b6-422a-850d-ae0184305ea7)


## 🔹 File Handling

A dedicated class, `Score`, manages file operations using `FileWriter` and `BufferedWriter`. After each game, the number of attempts is written to a file named `Record.txt`. This simple yet effective file handling ensures persistence of game data and demonstrates how Java programs can interact with external files for logging or data analysis purposes.

public class Score {

    public void countScore(int attempts){
        try(FileWriter fw = new FileWriter("Record.txt", true)){
            fw.write("Attempts made: " + attempts + "\n");
        } catch (IOException e) {
            System.out.println("Error while writing");
        }
    }
}

## 🔹 Graphical User Interface

The GUI is built using Java Swing components such as `JFrame`, `JLabel`, `JButton`, and `JTextField`. The layout is intuitive, user-friendly, and responsive. Input fields are clearly labeled, and game feedback is given immediately through a combination of labels and pop-up dialogs. The interface design ensures a seamless experience that aligns with the functionality and theme of the game.

![image](https://github.com/user-attachments/assets/d60223d0-ba8e-4b82-90da-f3f55c53eabd)

