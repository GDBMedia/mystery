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
  // @Test
  // public void letterReplace_testForAE() {
  //   MysteryWord yourApp = new MysteryWord();
  //   String expected = "--sy";
  //   assertEquals(expected, yourApp.letterReplace("easy"));
  // }
  // @Test
  // public void calculateScore_returnsRockScissors() {
  //   Allergy yourApp = new Allergy();
  //   Integer expected = 1;
  //   assertEquals(expected, yourApp.allergyTest("56"));
  // }
  // @Test
  // public void calculateScore_returnsRockRock() {
  //   Allergy yourApp = new Allergy();
  //   Integer expected = 3;
  //   assertEquals(expected, yourApp.winnerTest("rock", "rock"));
  // }
  // @Test
  // public void calculateScore_returnsPaperPaper() {
  //   Allergy yourApp = new Allergy();
  //   Integer expected = 3;
  //   assertEquals(expected, yourApp.winnerTest("paper", "paper"));
  // }
  // @Test
  // public void calculateScore_returnsScissorsPaper() {
  //   Allergy yourApp = new Allergy();
  //   Integer expected = 1;
  //   assertEquals(expected, yourApp.winnerTest("scissors", "paper"));
  // }
  // @Test
  // public void calculateScore_returnsScissorsScissors() {
  //   Allergy yourApp = new Allergy();
  //   Integer expected = 3;
  //   assertEquals(expected, yourApp.winnerTest("scissors", "scissors"));
  // }

}
