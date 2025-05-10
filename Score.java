import java.io.FileWriter;
import java.io.IOException;

public class Score {

    public void countScore(int attempts){
        try(FileWriter fw = new FileWriter("Record.txt", true)){
            fw.write("Attempts made: " + attempts + "\n");
        } catch (IOException e) {
            System.out.println("Error while writing");
        }
    }
}
