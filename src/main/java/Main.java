import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        System.out.println(readBuildVersion());
    }
    private static int readBuildVersion(){
        int buildNo = -1;
        Main mainInstance = new Main();
        File file = mainInstance.getFileFromResources("version.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            buildNo = Integer.parseInt(line);
        }
        catch(FileNotFoundException ex){
            System.out.println("File does not exist");
        }
        catch (IOException ex){
            System.out.println("Input exception");
        }
        catch(NumberFormatException ex){
            System.out.println("Cannot cast build no to file");
        }
        return buildNo;
    }
    private File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
