package org.tact.base.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(value = "/base")
@SuppressWarnings("unchecked")
public class BaseController {
	
	/**
	 * 
	 * @return
	 * 
	 * possible url:
     * 		/base
     *		http://localhost:1878/base
	 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }    
   
    /**
     * 
     * @param file
     * @param redirectAttributes
     * @return
     * 
     * possible url:
     * 		/base/upload
     *		http://localhost:1878/base/upload
     */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public <T> T upload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
    	
    	if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "");
            
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            
            map.put("result", 102);
            map.put("error", "Please select a file to upload");
            
            return (T) map;
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get("c:/test/" + file.getOriginalFilename());
            Files.write(path, bytes);

            Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("result", 0);
            map.put("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            map.put("error", "0");
            
            return (T) map;

        } catch (Exception e) {
        	
        	e.printStackTrace();
            
        	Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("result", 103);            
            map.put("error", "File upload Error : "+e.getMessage());
            
            return (T) map;
        }
    }
}
