package ru.denisshishin.task1anagram;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.RemoteException;
import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.service.autofill.Validators.not;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

import android.content.pm.ActivityInfo;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITests {
    @Rule
    public ActivityScenarioRule<MainActivity> activityTestRule = new ActivityScenarioRule<>(MainActivity.class);

    // сохранить в spoon
    @Test
    public void anagramIsDisplayed(){
       onView(withId(R.id.tietInputText)).perform(replaceText("xyz9 эюя?"));
       onView(withId(R.id.tietInputExceptionText)).perform(replaceText("9?"));
       onView(withId(R.id.btnReverse)).perform(click());
       onView(withId(R.id.tvOutput)).check(matches(withText("zyx9 яюэ?")));
    }

    @Test
    public void toastMessageIsDisplayed() {
        onView(withId(R.id.btnReverse)).perform(click());
        onView(withText("Вы ничего не ввели")).inRoot(ToastMatcher.isToast()).check(matches(isDisplayed()));
    }

    @Test
    public void instanceIsSavedWhenRecreatingActivity(){
        onView(withId(R.id.tietInputText)).perform(replaceText("xyz9 эюя?"));
        onView(withId(R.id.tietInputExceptionText)).perform(replaceText("9?"));
        onView(withId(R.id.btnReverse)).perform(click());

        activityTestRule.getScenario().recreate();

        onView(withId(R.id.tietInputText)).check(matches(withText("xyz9 эюя?")));
        onView(withId(R.id.tietInputExceptionText)).check(matches(withText("9?")));
        onView(withId(R.id.tvOutput)).check(matches(withText("zyx9 яюэ?")));
    }

    @Test
    public void instanceIsSavedWhenRotating(){
        onView(withId(R.id.tietInputText)).perform(replaceText("xyz9 эюя?"));
        onView(withId(R.id.tietInputExceptionText)).perform(replaceText("9?"));
        onView(withId(R.id.btnReverse)).perform(click());

        UiDevice device = UiDevice.getInstance(getInstrumentation());
        try {
            device.setOrientationLeft();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        onView(withId(R.id.tietInputText)).check(matches(withText("xyz9 эюя?")));
        onView(withId(R.id.tietInputExceptionText)).check(matches(withText("9?")));
        onView(withId(R.id.tvOutput)).check(matches(withText("zyx9 яюэ?")));
    }

    @After
    public void backToNaturalOrientation() throws RemoteException {
        UiDevice device = UiDevice.getInstance(getInstrumentation());
        device.setOrientationNatural();
    }
}

