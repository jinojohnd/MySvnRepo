package com.finastra.finance.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.finastra.finance.model.Attachments;
import com.finastra.finance.repository.AttachmentRepository;
import com.finastra.finance.service.EmailService;

@Component
public class PdfGenaratorUtil 
{
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AttachmentRepository attachmentRepository;
	
	@Value("${spring.pdf.output.path}")
	private String outputPath;
	
	@Async
	public void createAndSavePdf(String templateName, Map map, String fileName, int id) throws Exception 
	{
		Assert.notNull(templateName, "The templateName can not be null");
		Context ctx = new Context();
		if (map != null) 
		{
		     Iterator itMap = map.entrySet().iterator();
		       while (itMap.hasNext()) {
			  Map.Entry pair = (Map.Entry) itMap.next();
		          ctx.setVariable(pair.getKey().toString(), pair.getValue());
			}
		}
		
		String processedHtml = templateEngine.process(templateName, ctx);
		fileName = fileName +"_"+ new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());
		FileOutputStream os = null;
		try 
		{
		    final File outputFile = new File(outputPath+fileName+".pdf");
		    outputFile.createNewFile();
		    os = new FileOutputStream(outputFile);
		
		    ITextRenderer renderer = new ITextRenderer();
		    renderer.setDocumentFromString(processedHtml);
		    renderer.layout();
		    renderer.createPDF(os, false);
		    renderer.finishPDF();
		    System.out.println("PDF created successfully");
		    
		    Attachments atth = new Attachments();
		    byte[] array = Files.readAllBytes(outputFile.toPath());
		    atth.setFile_content(array);
		    atth.setFile_name(fileName);
		    atth.setFile_type(".pdf");
		    atth.setForex_id(id);
		    
		    attachmentRepository.saveAndFlush(atth);
		    
		    
		    emailService.sendMessageWithAttachment("sapna.m@misys.com", "test attachement", "my attachment", outputFile);
		    System.out.println("PDF sucessfully generated");
		}
		finally 
		{
		    if (os != null) 
		    {
		        try 
		        {
		            os.close();
		        } catch (IOException e) 
		        { /*ignore*/ }
		    }
		}
	}
}
