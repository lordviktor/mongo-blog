package io.github.lordviktor.mongoBlog;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class HelloWorldSparkFreemarkerStyle {

	public static void main(String[] args) {
		final Configuration configuration = new Configuration(Configuration.VERSION_2_3_25);
		configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
		
		Spark.get("/", new Route() {
			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				StringWriter writer = new StringWriter();
				try {
					Template helloTemplate = configuration.getTemplate("hello.tpl");
					Map<String, Object> variables = new HashMap<>();
					variables.put("name", "Freemarker");
					helloTemplate.process(variables, writer);
				} catch (TemplateException | IOException e) {
					e.printStackTrace();
				}
				return writer;
			}
		});
	}
}
