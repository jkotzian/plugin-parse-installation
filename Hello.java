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
public class Hello extends CordovaPlugin
{
    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("hello")) {
            // Get the given username
            String username = args.getString(0);
            // Find devices associated with that username
            ParseQuery installationQuery = ParseInstallation.getQuery();
            //pushQuery.whereMatchesQuery("username", username);
            installationQuery.whereEqualTo("username", username);
            installationQuery.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> installationList, ParseException e) {
                    if (e == null) {
                        String installationId = installationList.get(0).getString("installationId");
                        hello(installationId, callbackContext);
                        //Log.d("installation", "Retrieved " + installationList.size() + " installations");
                    } else {
                        hello("Error finding installation object!", callbackContext);
                        //Log.d("installation", "Error: " + e.getMessage());
                    }
                }
            });
            return true;
        }
        else if (action.equals("hey")) {
            //Get the current installationID
            ParseInstallation curParseInstallation = ParseInstallation.getCurrentInstallation();
            String username = args.getString(0);
            //Toast.makeText(this.cordova.getActivity().getApplicationContext(), username, Toast.LENGTH_LONG).show();
            //String currentUsername = ParseUser.getCurrentUser().getUsername();
            curParseInstallation.put("username", username);
            curParseInstallation.saveInBackground();
            this.hello("Successfully set installation username", callbackContext);
            return true;
        }
        return false;
    }

    private void hello(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
