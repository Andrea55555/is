import java.io.*;

public class WritingFile {

    public static void main(String[] args) {

        try(FileReader reader = new FileReader("iscl.txt"))
        {
// читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(Exception e){

            System.out.println(e.getMessage());
        }
    }
}