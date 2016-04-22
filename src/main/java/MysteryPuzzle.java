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


public class MysteryPuzzle {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");
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
      Integer score = getScore(finalString);

      model.put("score", score);
      model.put("sentence", sentence);
      model.put("finalString", finalString);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



    get("/detectorhint", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/detector.vtl");

      String finalString = request.queryParams("finalString");
      String sentence = request.queryParams("newSentence");
      Integer score = 1;
      if(score !=0){
      finalString = hint(finalString, sentence);
      }
      score = getScore(finalString);


      model.put("sentence", sentence);
      model.put("score", score);
      model.put("finalString", finalString);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



    get("/result", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/result.vtl");

      String solve = request.queryParams("solve");
      String score = request.queryParams("score");
      String newSentence = request.queryParams("newSentence");
      Boolean solvePuzzle = testTrue(solve, newSentence);

      model.put("score", score);
      model.put("solvePuzzle", solvePuzzle);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
  public static Integer getScore(String dashes){
    char[] charArray1 = dashes.toCharArray();
    Integer score = 0;
    for(int i = 0; i<charArray1.length; i++){
      if(charArray1[i] == '-'){
        score += 4;
      }
    }
    return score;

  }
  public static String hint(String dashes, String sentence){
    Random myRandomGenerator = new Random();
    char[] charArray1 = dashes.toCharArray();
    char[] charArray2 = sentence.toCharArray();
    int x = 0;
    while(x == 0){
      int i = myRandomGenerator.nextInt(charArray1.length);
      if(charArray1[i] == '-'){
        charArray1[i] = charArray2[i];
        x = 1;
      }

    }
    String returnString = new String(charArray1);
    return returnString;
  }
  public static Boolean testTrue(String solve, String sentence){
    Boolean bool = false;
    if(setLowerCase(solve).equals(setLowerCase(sentence))){
      bool = true;
    }
    return bool;
  }
  public static String setLowerCase(String x){
    return x.toLowerCase();
  }
  public static String letterReplace(String sentence) {
    String[] arrayOfLetters = {"a", "e", "i", "o", "u"};
    for(int i = 0; i<arrayOfLetters.length; i++){
      sentence = sentence.replaceAll("(?i)"+arrayOfLetters[i], "-");
    }
    return sentence;
  }
}
