package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class GetJokeAndroidTest {

    private static final String TAG = GetJokeAndroidTest.class.getSimpleName();

    private String mResult = null;

    private static CountDownLatch mSignal = null;

    @Rule
    public ActivityTestRule<MainTestActivity> mActivityRule = new ActivityTestRule<>(MainTestActivity.class);

    @BeforeClass
    public static void setUp() throws Exception {
        mSignal = new CountDownLatch(1);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        mSignal.countDown();
    }

    @Test
    public void testGetJoke() throws Exception {

        MainTestActivity mainTestActivity = mActivityRule.getActivity();
        mainTestActivity.setGetJokeCallback(new MainTestActivity.GetJokeTestCallback() {
            @Override
            public void onHandleResponseCalled(String result) {
                mResult = result;
                mSignal.countDown();
            }
        });

        onView(withText("Tell Joke")).perform(click());

        mSignal.await();

        assertTrue(mResult.length() > 0 && !mResult.equals("connect timed out"));
    }
}