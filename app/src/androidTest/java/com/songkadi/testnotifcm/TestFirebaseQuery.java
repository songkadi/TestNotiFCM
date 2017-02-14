package com.songkadi.testnotifcm;

import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by adapons on 2017-02-14.
 */

@RunWith(AndroidJUnit4.class)
public class TestFirebaseQuery {
    @Test
    public void select() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);

        DatabaseReference reference = database.getReference("wm91int:6300");
        reference.setValue("©2016 androidhive. All rights Reserved");

        String key = reference.push().getKey();
        reference.child(key).setValue("Person");

    }
}
