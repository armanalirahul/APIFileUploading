package com.api.api.FileHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Helper {

    // public final String FILE_UPLOAD =
    // "C:\\Users\\Aarman\\Documents\\workspace-spring-tool-suite-4-4.12.0.RELEASE\\SpringBoot\\api\\src\\main\\resources\\static\\images";

    public final String FILE_UPLOAD = new ClassPathResource("static/images/").getFile().getAbsolutePath();

    public Helper() throws IOException {

    }

    public boolean FileUploading(MultipartFile file) {
        boolean f = false;
        try {

            // InputStream iStream = file.getInputStream();
            // byte[] byteFile = new byte[iStream.available()];
            // iStream.read(byteFile);

            // FileOutputStream fileOutputStream = new FileOutputStream(
            // FILE_UPLOAD + File.separator + file.getOriginalFilename());
            // fileOutputStream.write(byteFile);

            // fileOutputStream.flush();
            // fileOutputStream.close();

            Files.copy(file.getInputStream(), Paths.get(FILE_UPLOAD + File.separator + file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);

            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
