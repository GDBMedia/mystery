import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MysteryWordTest {
//
  @Test
  public void letterReplace_testForA() {
    MysteryWord yourApp = new MysteryWord();
    String expected = "-s";
    assertEquals(expected, yourApp.letterReplace("as"));
  }
  @Test
  public void letterReplace_testForAE() {
    MysteryWord yourApp = new MysteryWord();
    String expected = "--sy";
    assertEquals(expected, yourApp.letterReplace("Easy"));
  }
  // @Test
  // public void letterReplace_testForI() {
  //   MysteryWord yourApp = new MysteryWord();
  //   String expected = "-t's";
  //   assertEquals(expected, yourApp.letterReplace("it's"));
  // }

}
