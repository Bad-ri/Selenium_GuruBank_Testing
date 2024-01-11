package Utilities;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    FileHandler file ;
    Logger log = Logger.getAnonymousLogger();

    public void logSetup(){
        try{
            file = new FileHandler("C:\\Users\\Badri\\Documents\\GitHub\\Selenium_GuruBank_Testing\\GuruBank\\src\\test\\resources\\Logs\\logs.log",true);
            file.setFormatter(new SimpleFormatter());
            log.addHandler(file);
            //log.info("--------------------------------RUN---------------------------------------");
        }catch (IOException e){
            log.severe("file not found");
        }

    }
    public Logger returnLog(){
        return log;
    }
    public void logTerminate (){
        log.removeHandler(file);
        file.close();
    }


}
