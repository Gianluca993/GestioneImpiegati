package com.gianluca.bc.utilities;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.gianluca.bc.model.Impiegato;

public class FileUploader {
	private static final String relativePath = "/resources/img/";
	private static final String path = "C:\\Users\\Betacom\\eclipse-workspace-webpj\\GestioneImpiegati\\WebContent\\resources\\img";
	private static File file;

//	public static String upload(CommonsMultipartFile img, Impiegato imp) {
//		String fileName = img.getOriginalFilename();
//		file = new File(path + "\\" + fileName);
//		if(imp.getImgUrl().length() != 0) {
//			int position = imp.getImgUrl().lastIndexOf("/");
//			String oldFileName = imp.getImgUrl().substring(position + 1);
//			File oldFile = new File(path + "\\" + oldFileName);
//			oldFile.delete();
//		}
//		try {
//			byte[] barr = img.getBytes();
//			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
//			out.write(barr);
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return relativePath + fileName;
//	}
	
	public static String upload(CommonsMultipartFile img, Impiegato imp) {
		if(img.isEmpty())
			return null;
		String fileName = img.getOriginalFilename();
		file = new File(path + "\\" + fileName);
		if(imp.getImgUrl() != null) {
			int position = imp.getImgUrl().lastIndexOf("/");
			String oldFileName = imp.getImgUrl().substring(position + 1);
			File oldFile = new File(path + "\\" + oldFileName);
			if(oldFile.exists())
				oldFile.delete();
		}
		try {
			InputStream io = img.getInputStream();
			BufferedImage imgio = ImageIO.read(io);
			ImageIO.write(imgio, FilenameUtils.getExtension(fileName), file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return relativePath + fileName;
	}
	
}
