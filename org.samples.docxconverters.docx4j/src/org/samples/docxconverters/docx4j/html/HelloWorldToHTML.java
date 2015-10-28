package org.samples.docxconverters.docx4j.html;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.stream.StreamResult;

import org.docx4j.convert.out.html.AbstractHtmlExporter;
import org.docx4j.convert.out.html.AbstractHtmlExporter.HtmlSettings;
import org.docx4j.convert.out.html.HtmlExporterNG2;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class HelloWorldToHTML {

	public static void main(String[] args) {
		createHTML();
		createHTML();
	}

	private static void createHTML() {
		try {
			long start = System.currentTimeMillis();

			// 1) Load DOCX into WordprocessingMLPackage
			InputStream is = new FileInputStream(new File(
					"docx/HelloWorld.docx"));
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
					.load(is);

			// 2) Prepare HTML settings
			HtmlSettings htmlSettings = new HtmlSettings();

			// 3) Convert WordprocessingMLPackage to HTML
			OutputStream out = new FileOutputStream(new File(
					"html/HelloWorld.html"));
			AbstractHtmlExporter exporter = new HtmlExporterNG2();
			StreamResult result = new StreamResult(out);
			exporter.html(wordMLPackage, result, htmlSettings);

			System.err.println("Generate html/HelloWorld.html with "
					+ (System.currentTimeMillis() - start) + "ms");

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
