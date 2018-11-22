package Set;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {
    public FileOperation() {
    }

    public static boolean readFile(String filename, ArrayList<String> words) {
        if (filename != null && words != null) {
            Scanner scanner;
            try {
                File file = new File(filename);
                if (!file.exists()) {
                    return false;
                }

                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } catch (IOException var7) {
                System.out.println("Cannot open " + filename);
                return false;
            }

            if (scanner.hasNextLine()) {
                String contents = scanner.useDelimiter("\\A").next();
                int start = firstCharacterIndex(contents, 0);
                int i = start + 1;

                while(true) {
                    while(i <= contents.length()) {
                        if (i != contents.length() && Character.isLetter(contents.charAt(i))) {
                            ++i;
                        } else {
                            String word = contents.substring(start, i).toLowerCase();
                            words.add(word);
                            start = firstCharacterIndex(contents, i);
                            i = start + 1;
                        }
                    }

                    return true;
                }
            } else {
                return true;
            }
        } else {
            System.out.println("filename is null or words is null");
            return false;
        }
    }

    private static int firstCharacterIndex(String s, int start) {
        for(int i = start; i < s.length(); ++i) {
            if (Character.isLetter(s.charAt(i))) {
                return i;
            }
        }

        return s.length();
    }
}
