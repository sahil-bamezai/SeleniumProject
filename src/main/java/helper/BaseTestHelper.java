package helper;

import java.io.File;
import java.util.Date;

public class BaseTestHelper {

    public static String Timestamp(){
        Date now = new Date();
        String Timestamp = now.toString().replace(":", "-");
        return Timestamp;
    }

    public static void CreateFolder(String path){
        //file is class inside java.io
        File file = new File(path);

        if(!file.exists()) {
            file.mkdir();// mkdir is used to create a folder
        }else {
            System.out.println("Folder already created");
        }

    }
}
