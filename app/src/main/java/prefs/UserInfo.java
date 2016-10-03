package prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 10/1/2016.
 */

public class UserInfo {
    private static final String TAG = UserSession.class.getSimpleName();
    private static final String PREF_NAME = "userinfo";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public UserInfo(Context ctx) {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences(PREF_NAME, ctx.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setUsername(String username){
        editor.putString(KEY_USERNAME, username);
        editor.apply();
    }

    public void setEmail(String email){
        editor.putString(KEY_EMAIL, email);
        editor.apply();
    }

    public void clearUserInfo(){
        editor.clear();
        editor.commit();
    }

    public String getKeyUsername(){return prefs.getString(KEY_USERNAME, "");}

    public String getKeyEmail(){return prefs.getString(KEY_EMAIL, "");}
}
