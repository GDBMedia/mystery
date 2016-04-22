import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MysteryPuzzleTest {
//
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
  public void letterReplace_testFortesttrue() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    Boolean expected = true;
    assertEquals(expected, yourApp.testTrue("because", "Because"));
  }
  @Test
  public void letterReplace_hint() {
    MysteryPuzzle yourApp = new MysteryPuzzle();
    String expected = "hey";
    assertEquals(expected, yourApp.hint("h-y", "hey"));
  }
}
