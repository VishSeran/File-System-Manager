
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileSystemManager {

    private File currentDirectory;

    private Scanner scanner;

    private SimpleDateFormat dateFormat;

    public FileSystemManager() {

        //initialize curretnDirectiry as the user current directory
        currentDirectory = new File(System.getProperty("user.dir"));
        //initialize the scanner for user input
        scanner = new Scanner(System.in);
        //initialize the date formatter for displaying timestamp
        dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    }

    //start method for filemanager
    public void start() {
        System.out.println("File Manager is starting...");
        System.out.println("Welcome to the File System Manager!");
        System.out.println("Type 'help' to see available commands.");

        boolean running = true;

        while (running) {

            //Display current directory path as prompt
            System.out.println(currentDirectory.getAbsolutePath() + ">");

            //Read user command
            String command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("System shutting down...");
                running = false;
            } else {
                running = processComand(command);
            }
        }

    }

    private boolean processComand(String command) {
        if (command.isEmpty()) {
            return true;
        }

        //split command into parts
        String[] parts = command.trim().split("\\s+", 2);
        String commandName = parts[0].toLowerCase();
        String args = parts.length > 1 ? parts[1] : "";

        switch (commandName) {
            case "help":
                displayHelp();
                break;
        }

        return true;
    }

    private static void displayHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("  help              - Display this help message");
        System.out.println("  ls                - List files in current directory");
        System.out.println("  cd <directory>    - Change to specified directory (use .. for parent)");
        System.out.println("  pwd               - Print current directory path");
        System.out.println("  mkdir <name>      - Create a new directory");
        System.out.println("  touch <name>      - Create a new file");
        System.out.println("  rm <name>         - Delete a file or directory");
        System.out.println("  rename <old> <new> - Rename a file or directory");
        System.out.println("  find <pattern>    - Search for files matching pattern");
        System.out.println("  info <name>       - Display file information");
        System.out.println("  exit              - Exit the program");
    }
}
