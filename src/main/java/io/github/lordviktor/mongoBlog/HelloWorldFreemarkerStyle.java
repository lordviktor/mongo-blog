package io.github.lordviktor.mongoBlog;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldFreemarkerStyle {

	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldFreemarkerStyle.class);

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

		try {
			Template helloTemplate = configuration.getTemplate("hello.tpl");
			StringWriter writer = new StringWriter();
			Map<String, Object> variables = new HashMap<>();
			variables.put("name", "Freemarker");

			helloTemplate.process(variables, writer);
			LOG.info(writer.toString());
		} catch (TemplateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
