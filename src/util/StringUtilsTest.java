package util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class StringUtilsTest {

  @RunWith(value = Parameterized.class) public static class test_toCamelCase {

    @Parameterized.Parameter()
    public String input;
    @Parameterized.Parameter(1)
    public String expected;
    @Parameterized.Parameter(2)
    public String assertMsg;

    @Parameterized.Parameters(name = " {index}: {2} ") public static Collection<Object[]> data() {
      //@formatter:off
      return Arrays.asList(new Object[][] {
        { null, "", "return empty string when arg is null" },
        { "", "", "return empty string when arg is empty string" },
        { "the_Stealth_Warrior", "theStealthWarrior", "test underscore lower start" },
        { "The_Stealth_Warrior", "TheStealthWarrior", "test underscore upper start" },
        { "the-Stealth-Warrior", "theStealthWarrior", "test some dash lower start" },
        { "The-Stealth-Warrior", "TheStealthWarrior", "test some dash upper start" },
        { "The-Stealth_Warrior", "TheStealthWarrior", "test some dash mix with underscore upper start" },
        { "the-Stealth_Warrior", "theStealthWarrior", "test some dash mix with underscore lower start" },
        {
          "Red-desert-right-Rockstar-Red-north-bridge-down-Black",
          "RedDesertRightRockstarRedNorthBridgeDownBlack",
          "should work with some random value"
        },
        {
          "You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields",
          "YouHaveChosenToTranslateThisKataForYourConvenienceWeHaveProvidedTheExistingTestCasesUsedForTheLanguageThatYouHaveAlreadyCompletedAsWellAsAllOfTheOtherRelatedFields",
          "test long one"
        },
      });
    }

    // @formatter:on
    @Test public void test() {
      String errMsg = String.format(assertMsg + "\nshould return 「%s」if input is 「%s」」", expected, input);
      String actual = StringUtils.toCamelCase(input);
      Assert.assertEquals(errMsg, expected, actual);
    }
  }
}