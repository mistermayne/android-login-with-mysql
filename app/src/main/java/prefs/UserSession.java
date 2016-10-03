package prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 10/1/2016.
 */

public class UserSession {
    private static final String TAG = UserSession.class.getSimpleName();
    private static final String PREF_NAME = "login";
    private static final String KEY_IS_LOGGED_IN = "isloggedin";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public UserSession(Context ctx) {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(PREF_NAME, ctx.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedin(boolean isLoggedin){
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedin);
        editor.apply();
    }

    public boolean isUserLoggedin(){return prefs.getBoolean(KEY_IS_LOGGED_IN, false);}
}
