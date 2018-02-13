package com.finastra.finance.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finastra.finance.service.UserService;
import com.finastra.finance.util.Utils;

@Controller
public class UploadController 
{
	@Autowired
	private UserService userService;
	
	@Value("${spring.upload.output.path}")
	private String UPLOADED_FOLDER;
	
	@RequestMapping(value= "/uploads", method = RequestMethod.GET)
	public ModelAndView getUpload()
	{
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("upload");
		return modelAndView;
	}
	
	@RequestMapping(value= "/upload/centrumBill", method = RequestMethod.GET)
	public ModelAndView openUpload()
	{
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.addObject("module", "upload");
		modelAndView.setViewName("list_forex_reports");
		return modelAndView;
	}
	
	@RequestMapping(value= "/upload/upload-centrum-bill", method = RequestMethod.GET)
	public ModelAndView performUpload(@RequestParam("id") int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("uploadCentrum");
		return modelAndView;
	}
	
	 @PostMapping("/upload/uploadFile") 
	 public String singleFileUpload(@RequestParam("file") MultipartFile file,
	                                   RedirectAttributes redirectAttributes) 
	 {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/upload/uploadStatus";
    }

 	@RequestMapping(value= "/upload/uploadStatus", method = RequestMethod.GET)
	public ModelAndView getUploadStatus()
	{
		ModelAndView modelAndView = new ModelAndView();
		Utils.getUserName(modelAndView, userService);
		modelAndView.setViewName("uploadStatus");
		return modelAndView;
	}
	
}
