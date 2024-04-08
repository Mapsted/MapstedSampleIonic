package cordova.plugin.mapsted;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.res.Resources;


// Import statements for Mapsted functionality
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import com.mapsted.ui.MapstedMapUiApi;
import com.mapsted.ui.CustomParams;
import com.mapsted.ui.MapUiApi.MapUiInitCallback;
import com.mapsted.map.views.MapPanType;
import com.mapsted.map.models.layers.BaseMapStyle;
import com.mapsted.ui.MapstedMapUiApiProvider;
import android.widget.FrameLayout;
import com.mapsted.positioning.coreObjects.BuildingInfo;
import com.mapsted.positioning.SdkError;
import com.mapsted.positioning.SdkStatusUpdate;
import com.mapsted.map.MapApi;
import com.mapsted.ui.MapUiApi;
import com.mapsted.positioning.CoreApi;
import com.mapsted.ui.MapstedMapUiApi;
import com.mapsted.map.views.MapstedMapRange;
import java.util.stream.Collectors;
import android.widget.ProgressBar;

import com.mapsted.ui.map.MapstedMapActivity;
import com.mapsted.ui.search.SearchCallbacksProvider;

/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaPluginMapsted extends CordovaPlugin {

     private static final String TAG = "CordovaPluginMapsted";

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("echo")) {
            this.echo(args, callbackContext);
            return true;
        } else if (action.equals("launchMapActivity")) {
            this.launchMapActivity(callbackContext);
            return true;
        } else if (action.equals("getSearchCoreSdkCallback")) {
            this.getSearchCoreSdkCallback(callbackContext);
            return true;
        } else if (action.equals("getSearchFeedCallback")) {
            this.getSearchFeedCallback(callbackContext);
            return true;
        } else if (action.equals("getSearchAlertCallback")) {
            this.getSearchAlertCallback(callbackContext);
            return true;
        }

        return false;
    }

    public void echo(JSONArray args, CallbackContext callback) {
        Log.e(TAG, "echo method called");
        try {
            String value = args.getString(0);
            callback.success(value);
        } catch (JSONException e) {
            callback.error("Something went wrong" + e);
            callback.error("Error parsing arguments: " + e.getMessage());
        }
    }

    public void launchMapActivity(CallbackContext callback) {
        try {
            Intent intent = new Intent(this.cordova.getActivity(), MapstedMapActivity.class);
            this.cordova.getActivity().startActivity(intent);
            callback.success();
        } catch (Exception e) {
                callback.error("Something went wrong" + e);
        }
    }


    public void getSearchCoreSdkCallback(CallbackContext callback) {
        try {
            JSONObject result = new JSONObject();
            result.put("message", "SearchCoreSdkCallback is not implemented");
            callback.error(result);
        } catch (JSONException e) {
            Log.e(TAG, "Error in getSearchCoreSdkCallback", e);
            callback.error("Error occurred: " + e.getMessage()); // Pass a string message
        }
    }

    public void getSearchFeedCallback(CallbackContext callback) {
        try {
            JSONObject result = new JSONObject();
            result.put("message", "SearchFeedCallback is not implemented");
            callback.error(result);
        } catch (JSONException e) {
            Log.e(TAG, "Error in getSearchFeedCallback", e);
            callback.error("Error occurred: " + e.getMessage()); // Pass a string message
        }
    }

    public void getSearchAlertCallback(CallbackContext callback) {
        try {
            JSONObject result = new JSONObject();
            result.put("message", "SearchAlertCallback is not implemented");
            callback.error(result);
        } catch (JSONException e) {
            Log.e(TAG, "Error in getSearchAlertCallback", e);
            callback.error("Error occurred: " + e.getMessage()); // Pass a string message
        }
    }

}
