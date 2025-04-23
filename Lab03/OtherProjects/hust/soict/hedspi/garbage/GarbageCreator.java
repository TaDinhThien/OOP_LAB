package hust.soict.hedspi.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "D:\\Lab\\Lab03\\OtherProjects\\hust\\soict\\hedspi\\garbage\\test.txt";
        byte[] inputBytes;
        long startTime, endTime;
        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outputString = "";
        for(byte b : inputBytes) {
            outputString += (char)b;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println(outputString); 
    }
}
