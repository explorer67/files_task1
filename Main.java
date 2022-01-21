package files_task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        String result = createDirectory("D://Games/src");
        sb.append(result).append("\n");

        result = createDirectory("D://Games/res");
        sb.append(result).append("\n");

        result = createDirectory("D://Games/savegames");
        sb.append(result).append("\n");

        result = createDirectory("D://Games/temp");
        sb.append(result).append("\n");

        result = createDirectory("D://Games/src/main");
        sb.append(result).append("\n");

        result = createDirectory("D://Games/src/test");
        sb.append(result).append("\n");

        result = createFile("D://Games/src/main", "Main.java");
        sb.append(result).append("\n");

        result = createFile("D://Games/src/main", "Utils.java");
        sb.append(result).append("\n");

        result = createDirectory("D://Games/res/drawables");
        sb.append(result).append("\n");

        result = createDirectory("D://Games/res/vectors");
        sb.append(result).append("\n");

        result = createDirectory("D://Games/res/icons");
        sb.append(result).append("\n");

        result = createFile("D://Games/temp", "temp.txt");
        sb.append(result).append("\n");

        result = sb.toString();
        try(FileWriter writer = new FileWriter("D://Games/temp/temp.txt", false)){
            writer.write(result);
            writer.append('\n');
            writer.append('!');
            writer.flush();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
    public static String createDirectory(String path){
        String result;
        File dir = new File(path);
        if (dir.mkdir()) {
            result = "Каталог " + path + " создан";
        }
        else {
            result = "Не удалось создать каталог " + path;
        }
        return result;
    }

    public static String createFile(String path, String fileName){
        String result = "!";
        File file = new File(path, fileName);
        try {
            if (file.createNewFile()) {
                result = "Файл " + fileName + " создан";
            }
            else {
                result = "Не удалось создать файл " + fileName;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
