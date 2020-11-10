package ru.denisshishin.task1anagram;

import android.content.Intent;
import android.os.RemoteException;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

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
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

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
        UiDevice device = UiDevice.getInstance(getInstrumentation());
        try {
            device.setOrientationLeft();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        spoon.screenshot(mainActivityThree, "ScreenC4");
        onView(withId(R.id.tietInputText)).check(matches(withText("xyz9 эюя?")));
        spoon.screenshot(mainActivityThree, "ScreenC5");
        onView(withId(R.id.tietInputExceptionText)).check(matches(withText("9?")));
        spoon.screenshot(mainActivityThree, "ScreenC6");
        onView(withId(R.id.tvOutput)).check(matches(withText("zyx9 яюэ?")));
        spoon.screenshot(mainActivityThree, "ScreenC7");
    }

    @After
    public void backToNaturalOrientation() throws RemoteException {
        UiDevice device = UiDevice.getInstance(getInstrumentation());
        device.setOrientationNatural();
    }

}

