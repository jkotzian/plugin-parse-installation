package org.apache.cordova.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Application;
import org.apache.cordova.*;
import com.parse.Parse.*;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.FindCallback;
import com.parse.ParseException;

import java.util.List;
import android.widget.Toast;
import android.content.Context;

/**
 * This class echoes a string called from JavaScript.
 */
public class MyInstallation extends CordovaPlugin
{
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("installation")) {
            //Get the current installationID
            ParseInstallation curParseInstallation = ParseInstallation.getCurrentInstallation();
            String username = args.getString(0);
            // Set the "username" field to the passed in current username
            curParseInstallation.put("username", username);
            curParseInstallation.saveInBackground();
            this.installation("Successfully set installation username", callbackContext);
            return true;
        }
        return false;
    }

    private void installation(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
