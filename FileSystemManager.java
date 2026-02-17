import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class FileSystemManager {
    private File currentDirectory;

    private Scanner scanner;

    private SimpleDateFormat dateFormat;

    public FileSystemManager(){

        //initialize curretnDirectiry as the user current directory
        currentDirectory = new File(System.getProperty("user.dir"));
        //initialize the scanner for user input
        scanner = new Scanner(System.in);
        //initialize the date formatter for displaying timestamp
        dateFormat = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
    }

    //start method for filemanager
    public void start(){
        System.out.println("File Manager is starting...");
        System.out.println("Welcome to the File System Manager!");
        System.out.println("Type 'help' to see available commands.");

        boolean running = true;

        while(running){

            //Display current directory path as prompt
            System.out.println(currentDirectory.getAbsolutePath() + ">");

            //Read user command
            String command = scanner.nextLine().trim();

            if(command.equalsIgnoreCase("exit")){
                System.out.println("System shutting down...");
                running= false;
            }else{
                running = processComand(command);
            }
        }

    }

    private boolean processComand(String command){
        if(command.isEmpty()){
            return true;
        }

        

        return true;
    }
}
