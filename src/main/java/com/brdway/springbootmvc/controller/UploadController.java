package com.brdway.springbootmvc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

	@GetMapping("/upload")
	public String getupload() {
		return"UploadForm";
	}
	
	@PostMapping("/upload")
	public String postupload(@RequestParam("image") MultipartFile image, Model model) throws IOException {
		
		String IMG_PATH ="src/main/resources/static/images/";
		if(!image.isEmpty()) {
			Files.copy(image.getInputStream(), Path.of(IMG_PATH+ image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			model.addAttribute("message","upload success");
			return"UploadForm";
		}
		model.addAttribute("message","upload failed");
		return"UploadForm";
	}
}
