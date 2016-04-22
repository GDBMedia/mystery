import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.Object;
import java.lang.String;
import spark.ModelAndView;
import static java.lang.System.out;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Random;


public class MysteryWord {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/detector", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String sentence = request.queryParams("sentence");
      String finalString = letterReplace(sentence);

      // model.put("finalString", finalString);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
  public static String letterReplace(String sentence) {
    String[] arrayOfLetters = {"a", "e"};
    for(int i = 0; i<arrayOfLetters.length; i++){
      sentence = sentence.replaceAll("(?i)"+arrayOfLetters[i], "-");
    }
    return sentence;
  }
}
