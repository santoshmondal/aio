package org.samples.docxconverters.xdocreport.html;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class FormattingTestsToHTML {

	public static void main(String[] args) {
		createHTML();
		createHTML();
	}

	private static void createHTML() {
		try {
			long start = System.currentTimeMillis();

			// 1) Load DOCX into XWPFDocument
			InputStream is = new FileInputStream(new File(
					"docx/FormattingTests.docx"));
			XWPFDocument document = new XWPFDocument(is);

			// 2) Prepare Html options
			XHTMLOptions options = XHTMLOptions.create();
			// Extract image
	        File imageFolder = new File( "html/images/FormattingTests/" );
	        imageFolder.getParentFile().mkdirs();
	        options.setExtractor( new FileImageExtractor( imageFolder ) );	        
	        // URI resolver
	        options.URIResolver( new FileURIResolver( imageFolder ) );
	        
			// 3) Convert XWPFDocument to HTML
			OutputStream out = new FileOutputStream(new File(
					"html/FormattingTests.html"));
			XHTMLConverter.getInstance().convert(document, out, options);

			System.err.println("Generate html/FormattingTests.html with "
					+ (System.currentTimeMillis() - start) + "ms");

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
