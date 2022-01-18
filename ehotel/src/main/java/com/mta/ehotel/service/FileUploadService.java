package com.mta.ehotel.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	
	public String uploadFile(MultipartFile file,String forderDir) throws IOException{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			String uploadDir = "./Upload/Avatar/"+forderDir;
			Path uploadPath = Paths.get(uploadDir);
		
			if(!Files.exists(uploadPath)) {
				Files.createDirectories(uploadPath);
			}
			InputStream inputStream = file.getInputStream();
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		} catch (IOException e) {
			throw new IOException("Could not save file: " + fileName);
		}
	}
	
}
