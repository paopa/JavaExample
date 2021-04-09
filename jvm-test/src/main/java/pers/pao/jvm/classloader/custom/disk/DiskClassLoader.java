package pers.pao.jvm.classloader.custom.disk;

import lombok.AllArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@AllArgsConstructor
public class DiskClassLoader extends ClassLoader {

    private String mLibPath;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getFileName(name);
        File file = new File(mLibPath, fileName);
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int len = 0;
            try {
                while ((len = fis.read()) != -1) {
                    baos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] data = baos.toByteArray();
            return defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private String getFileName(String name) {
        String extension = ".class";
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return name + extension;
        }
        return name.substring(index + 1) + extension;
    }
}