package com.univali.listadecompras;

import android.app.Activity;
import android.view.View;

public abstract class Utils {

    public static Activity getActivity(final View view) {
        return (Activity) view.findViewById(android.R.id.content).getContext();
    }
}
