package com.cos.myapplication3.helper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.cos.myapplication3.MainActivity;
import com.cos.myapplication3.PersonActivity;
import com.cos.myapplication3.R;
import com.google.android.material.navigation.NavigationView;

public class NavigationViewHelper {
    private static final String TAG = "NavigationViewHelper";

    public static void enable(Context context, NavigationView view) {
        view.setNavigationItemSelectedListener(item -> {
            Log.d(TAG, "onCreate: item id = :" + item.getItemId());
            int id = item.getItemId();

            if (id == R.id.item1) {
                Toast.makeText(context, "iyem1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);
            } else if (id == R.id.item2) {
                Toast.makeText(context, "item2!" + id, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, PersonActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                context.startActivity(intent);

            } else if (id == R.id.item3) {
                Toast.makeText(context, "item3!" + id, Toast.LENGTH_SHORT).show();
            }

            return true;
        });
    }
}
