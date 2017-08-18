/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author LENOVO
 */
public class FileUtil {
    public static String pathPhotoSinistre = "C:\\Users\\misa\\Documents\\GitHub\\aro\\DevisAutoAro\\DevisAutoAro-war\\web\\resources\\photos_sinistre\\";

    public static void writeInFile(String data, String fileName) throws IOException {
        Files.write(Paths.get(fileName), data.getBytes());
    }

    public static String getContentFile(String fileName) throws IOException {
        Stream<String> stream = null;
        try {
            String content = "";
            stream = Files.lines(Paths.get(fileName));
            content += stream.collect(Collectors.joining());
            return content;
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

    }
}
