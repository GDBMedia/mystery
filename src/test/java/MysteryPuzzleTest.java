import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class MysteryPuzzleTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Mystery Puzzle");
  }
  @Test
  public void detectorIsWorking() {
    goTo("http://localhost:4567");
    fill("#sentence").with("hey");
    submit(".btn");
    assertThat(pageSource()).contains("h-y");
  }
  @Test
  public void detectorResultIsWorking() {
    goTo("http://localhost:4567");
    fill("#sentence").with("hey");
    submit(".btn");
    assertThat(pageSource()).contains("h-y");
    click("#mybutton");
    fill("#solve").with("hey");
    submit(".mysubmit");
    assertThat(pageSource()).contains("You guessed right!!");
  }
  @Test
  public void detectorResultIsFailing() {
    goTo("http://localhost:4567");
    fill("#sentence").with("hey");
    submit(".btn");
    assertThat(pageSource()).contains("h-y");
    click("#mybutton");
    fill("#solve").with("hoy");
    submit(".mysubmit");
    assertThat(pageSource()).contains("you guessed wrong :(");
  }
  @Test
  public void hintWorking() {
    goTo("http://localhost:4567");
    fill("#sentence").with("hey");
    submit(".btn");
    assertThat(pageSource()).contains("h-y");
    submit("#hint");
    assertThat(pageSource()).contains("hey");
  }
  @Test
  public void letterReplace_testForA() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    String expected = "-s";
    assertEquals(expected, yourApp.letterReplace("as"));
  }
  @Test
  public void letterReplace_testForAE() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    String expected = "--sy";
    assertEquals(expected, yourApp.letterReplace("easy"));
  }
  @Test
  public void letterReplace_testForI() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    String expected = "-t's";
    assertEquals(expected, yourApp.letterReplace("it's"));
  }
  @Test
  public void letterReplace_testForO() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    String expected = "-b-m-";
    assertEquals(expected, yourApp.letterReplace("obama"));
  }
  @Test
  public void letterReplace_testForU() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    String expected = "b-c--s-";
    assertEquals(expected, yourApp.letterReplace("because"));
  }
  @Test
  public void letterReplace_testForAllAndCaps() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    String expected = "Q-----NG, -----, C-----NG, M-----D, Z-----, J-SS-----N, Z-----, Z-----";
    assertEquals(expected, yourApp.letterReplace("QUEUEING, AIEEE, COOEEING, MIAOUED, ZAOUIA, JUSSIEUEAN, ZOOEAE, ZOAEAE"));
  }
  @Test
  public void testTrue_testFortesttrue() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    Boolean expected = true;
    assertEquals(expected, yourApp.testTrue("because", "Because"));
  }
  @Test
  public void hint_hint() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    String expected = "hey";
    assertEquals(expected, yourApp.hint("h-y", "hey"));
  }
}
