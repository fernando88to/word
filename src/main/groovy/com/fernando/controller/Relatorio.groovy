package com.fernando.controller

import groovy.transform.CompileStatic
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun

@CompileStatic
@Controller('/relatorio')
class Relatorio {

    @Get(uri = '/termo')
    @Produces(MediaType.TEXT_PLAIN)
    String index(){
        //Instantiate WordGenerator Class
        //Blank Document
        XWPFDocument document = new XWPFDocument();




        //Write the Document in file system
        FileOutputStream out = new FileOutputStream("createdWord" + "_" + ".docx");
//create Paragraph
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("VK Number (Parameter): " +" here you type your text...\n");
        document.write(out);
        //Close document
        out.close();

        return "ok2"
    }
}
