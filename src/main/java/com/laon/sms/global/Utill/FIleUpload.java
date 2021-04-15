package com.laon.sms.global.Utill;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FIleUpload {


    private static  String path = "C:\\Users\\준혁\\IdeaProjects\\sms_be_spring\\upload";




 public static void upLoadImage(MultipartFile img, String location) throws IOException {


     File targetFile = new File(path+location);

     if(!targetFile.isDirectory()){

         targetFile.mkdirs();
     }

     img.transferTo(targetFile);

 }

}