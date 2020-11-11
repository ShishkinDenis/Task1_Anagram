package ru.denisshishin.task1anagram;

import android.content.Intent;
import android.content.pm.ActivityInfo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.squareup.spoon.SpoonRule;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITests {
    @Rule
    public SpoonRule spoon = new SpoonRule();
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);


   @Test
    public void anagramIsDisplayed(){
        MainActivity mainActivityOne = activityTestRule.launchActivity(new Intent());
        spoon.screenshot(mainActivityOne,"ScreenA0");
       onView(withId(R.id.tietInputText)).perform(replaceText("xyz9 эюя?"));
       spoon.screenshot(mainActivityOne,"ScreenA1");
       onView(withId(R.id.tietInputExceptionText)).perform(replaceText("9?"));
        spoon.screenshot(mainActivityOne,"ScreenA2");
       onView(withId(R.id.btnReverse)).perform(click());
        spoon.screenshot(mainActivityOne,"ScreenA3");
       onView(withId(R.id.tvOutput)).check(matches(withText("zyx9 яюэ?")));
        spoon.screenshot(mainActivityOne,"ScreenA4");
    }

    @Test
    public void toastMessageIsDisplayed() {
        MainActivity mainActivityTwo = activityTestRule.launchActivity(new Intent());
        spoon.screenshot(mainActivityTwo,"ScreenB0");
        onView(withId(R.id.btnReverse)).perform(click());
        spoon.screenshot(mainActivityTwo,"ScreenB1");
        onView(withText("Вы ничего не ввели")).inRoot(ToastMatcher.isToast()).check(matches(isDisplayed()));
        spoon.screenshot(mainActivityTwo,"ScreenB2");
    }

   @Test
    public void instanceIsSavedWhenRotating(){
        MainActivity mainActivityThree = activityTestRule.launchActivity(new Intent());
        spoon.screenshot(mainActivityThree, "ScreenC0");
        onView(withId(R.id.tietInputText)).perform(replaceText("xyz9 эюя?"));
        spoon.screenshot(mainActivityThree, "ScreenC1");
        onView(withId(R.id.tietInputExceptionText)).perform(replaceText("9?"));
        spoon.screenshot(mainActivityThree, "ScreenC2");
        onView(withId(R.id.btnReverse)).perform(click());
        spoon.screenshot(mainActivityThree, "ScreenC3");

        mainActivityThree.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE );

        spoon.screenshot(mainActivityThree, "ScreenC4");
        onView(withId(R.id.tietInputText)).check(matches(withText("xyz9 эюя?")));
        spoon.screenshot(mainActivityThree, "ScreenC5");
        onView(withId(R.id.tietInputExceptionText)).check(matches(withText("9?")));
        spoon.screenshot(mainActivityThree, "ScreenC6");
        onView(withId(R.id.tvOutput)).check(matches(withText("zyx9 яюэ?")));
        spoon.screenshot(mainActivityThree, "ScreenC7");
    }

    @After
    public void backToNaturalOrientation() {
        activityTestRule.getActivity().setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
    }

    @Test
    public void anagramOfSpaceIsDisplayed(){
        MainActivity mainActivityFour = activityTestRule.launchActivity(new Intent());
        spoon.screenshot(mainActivityFour,"ScreenD0");
        onView(withId(R.id.tietInputText)).perform(replaceText(" "));
        spoon.screenshot(mainActivityFour,"ScreenD1");
        onView(withId(R.id.btnReverse)).perform(click());
        spoon.screenshot(mainActivityFour,"ScreenD3");
        onView(withId(R.id.tvOutput)).check(matches(withText("")));
        spoon.screenshot(mainActivityFour,"ScreenD4");
    }

    @Test
    public void anagramWithIgnoredDigitsIsDisplayed(){
        MainActivity mainActivityFive = activityTestRule.launchActivity(new Intent());
        spoon.screenshot(mainActivityFive,"ScreenD0");
        onView(withId(R.id.tietInputText)).perform(replaceText("Foxminded cool 24/7"));
        spoon.screenshot(mainActivityFive,"ScreenD1");
        onView(withId(R.id.tietInputExceptionText)).perform(replaceText("0123456789"));
        spoon.screenshot(mainActivityFive,"ScreenD2");
        onView(withId(R.id.btnReverse)).perform(click());
        spoon.screenshot(mainActivityFive,"ScreenD3");
        onView(withId(R.id.tvOutput)).check(matches(withText("dednimxoF looc 24/7")));
        spoon.screenshot(mainActivityFive,"ScreenD4");
    }

    @Test
    public void anagramWithIgnoredXLIsDisplayed(){
        MainActivity mainActivitySix = activityTestRule.launchActivity(new Intent());
        spoon.screenshot(mainActivitySix,"ScreenE0");
        onView(withId(R.id.tietInputText)).perform(replaceText("Foxminded cool 24/7"));
        spoon.screenshot(mainActivitySix,"ScreenE1");
        onView(withId(R.id.tietInputExceptionText)).perform(replaceText("xl"));
        spoon.screenshot(mainActivitySix,"ScreenE2");
        onView(withId(R.id.btnReverse)).perform(click());
        spoon.screenshot(mainActivitySix,"ScreenE3");
        onView(withId(R.id.tvOutput)).check(matches(withText("dexdnimoF oocl 7/42")));
        spoon.screenshot(mainActivitySix,"ScreenE4");
    }

    @Test
    public void ifEmptyInputEmptyOutputIsDisplayed(){
        MainActivity mainActivitySeven = activityTestRule.launchActivity(new Intent());
        spoon.screenshot(mainActivitySeven,"ScreenF0");
        onView(withId(R.id.tietInputText)).perform(replaceText(""));
        spoon.screenshot(mainActivitySeven,"ScreenF1");
        onView(withId(R.id.tietInputExceptionText)).perform(replaceText(""));
        spoon.screenshot(mainActivitySeven,"ScreenF2");
        onView(withId(R.id.btnReverse)).perform(click());
        spoon.screenshot(mainActivitySeven,"ScreenF3");
        onView(withId(R.id.tvOutput)).check(matches(withText("")));
        spoon.screenshot(mainActivitySeven,"ScreenF4");
    }

    @Test
    public void anagramWithSpecificSymbolsIsDisplayed(){
        MainActivity mainActivityEight = activityTestRule.launchActivity(new Intent());
        spoon.screenshot(mainActivityEight,"ScreenG0");
        onView(withId(R.id.tietInputText)).perform(
                replaceText("!\\\"#$%&’()*+,-./:;<=>?@[]^_`{|}~."));
        spoon.screenshot(mainActivityEight,"ScreenG1");
        onView(withId(R.id.tietInputExceptionText)).perform(replaceText("+-:"));
        spoon.screenshot(mainActivityEight,"ScreenG2");
        onView(withId(R.id.btnReverse)).perform(click());
        spoon.screenshot(mainActivityEight,"ScreenG3");
        onView(withId(R.id.tvOutput)).check(matches(withText(".~}|{`_^][@+?->=:<;/.,*)(’&%$#\"\\!")));
        spoon.screenshot(mainActivityEight,"ScreenG4");
    }

}

