package com.fernando.services

import org.apache.poi.xwpf.usermodel.XWPFDocument
import org.apache.poi.xwpf.usermodel.XWPFParagraph
import org.apache.poi.xwpf.usermodel.XWPFRun

@Singleton
class GerarWordTermo {

    XWPFDocument gerarTermo(){
        XWPFDocument document = new XWPFDocument();
//create Paragraph
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("VK Number (Parameter): " +" here you type your text...\n");
        return document

    }
}
