package Idiomas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Language extends Properties{
    public static final int spanish = 0;
    public static final int english = 1;
    public Language(int lang){

        switch (lang) {
            case spanish -> getProperties("src/Idiomas/espanol.properties");
            case english -> getProperties("src/Idiomas/ingles.properties");
        }
    }

    private void getProperties(String langFile) {
        try {
            this.load( new FileInputStream(langFile));
        } catch (IOException ex) {
            System.out.println("Error loading language");
        }
    }
}