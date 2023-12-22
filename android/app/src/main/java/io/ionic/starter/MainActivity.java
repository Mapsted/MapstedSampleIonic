package io.ionic.starter;

import android.os.Bundle;
import android.util.Log;

import com.mapsted.MapstedBaseApplication;
import com.mapsted.positioning.core.map_download.PropertyDownloadManager;
import com.getcapacitor.BridgeActivity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.mapsted.ui.CustomParams;
import com.mapsted.ui.MapUiApi;
import com.mapsted.ui.MapUiApi.MapUiInitCallback;
import com.mapsted.map.views.MapPanType;
import com.mapsted.map.views.MapstedMapRange;
import com.mapsted.map.models.layers.BaseMapStyle;
import com.mapsted.positioning.CoreApi;
import com.mapsted.positioning.CoreApi.LocationServicesCallback;
import com.mapsted.positioning.CoreParams;
import com.mapsted.positioning.MapstedCoreApiProvider;
import com.mapsted.positioning.SdkError;
import com.mapsted.positioning.SdkStatusUpdate;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import android.widget.ProgressBar;
import com.mapsted.map.MapApi;
import com.mapsted.ui.MapstedMapUiApiProvider;
import com.mapsted.ui.MapUiApi;
import com.mapsted.ui.MapstedMapUiApi;

import android.content.res.Configuration;
import androidx.databinding.DataBindingUtil;
import com.mapsted.map.MapstedMapApi;
import com.mapsted.ui.map.MapstedMapActivity;
import com.mapsted.ui.search.SearchCallbacksProvider;



import java.util.stream.Collectors;

import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import java.util.Locale;
public class MainActivity extends BridgeActivity implements MapstedCoreApiProvider{
    private CoreApi coreApi;
    private MapUiApi mapUiApi;

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private long tActivityStart = 0L;
    private long tStartInitMapsted = 0L;
    private long tInitMapstedFinished = 0L;
    private long tStartDownload = 0L;
    private long tDownloadFinished = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        registerPlugin(MapstedIonicPlugin.class);
//        coreApi = ((MapstedBaseApplication) getApplication()).getCoreApi(this);

        super.onCreate(savedInstanceState);

//        tActivityStart = System.currentTimeMillis();

        Log.d(TAG, "onCreate");
//        setupMapstedSdk();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @PluginMethod
    public void launchMapActivity(PluginCall call) {
        try {
            Intent intent = new Intent(this, MapstedMapActivity.class);
            startActivity(intent);
            // Call setupMapUiApi after launching MapstedMapActivity
            setupMapUiApi(this);
            call.resolve();
        } catch (Exception e) {
            call.reject("Failed to launch Map Activity", e);
        }
    }

    private void setupMapUiApi(AppCompatActivity context) {
    // Check if MapUiApi is initialized
     Log.e(TAG, "MapUiApi ********************************.");

     if (mapUiApi == null) {
        Log.e(TAG, "MapUiApi is null. Initialization failed.");
        return;
    }

    // Create CustomParams for MapUiApi initialization
    CustomParams params = CustomParams.newBuilder(this, findViewById(R.id.flBaseMap), findViewById(R.id.flMapUi))
            .setBaseMapStyle(BaseMapStyle.GREY)
            .setMapPanType(MapPanType.RESTRICT_TO_SELECTED_PROPERTY)
            .setMapZoomRange(new MapstedMapRange(6.0f, 24.0f))
            .setEnableMapOverlayFeature(true)
            .build();

    // Check if CustomParams is successfully created
    if (params == null) {
        Log.e(TAG, "CustomParams is null. Initialization failed.");
        return;
    }

    // Initialize MapUiApi
    mapUiApi.setup().initialize(
            params,
            new MapUiInitCallback() {
                @Override
                public void onCoreInitialized() {
                    Log.d(TAG, "MapUiApi: onCoreInitialized");
                }

                @Override
                public void onMapInitialized() {
                    Log.d(TAG, "MapUiApi: onMapInitialized");
                    // Additional initialization or logging...
                }

                @Override
                public void onSuccess() {
                    Log.d(TAG, "MapUiApi: onSuccess");
                    // Additional logic...

                    // Call other methods or perform actions after MapUiApi initialization
                }

                @Override
                public void onFailure(SdkError sdkError) {
                    Log.e(TAG, "MapUiApi: onFailure: " + sdkError);
                    // Handle failure appropriately...
                }

                @Override
                public void onStatusUpdate(SdkStatusUpdate sdkUpdate) {
                    Log.d(TAG, "MapUiApi: onStatusUpdate: " + sdkUpdate);
                    // Handle status updates...
                }
            },
            new CoreApi.LocationServicesCallback() {
                @Override
                public void onSuccess() {
                    Log.d(TAG, "MapUiApi: LocServices: onSuccess");
                    // Handle location services success...
                }

                @Override
                public void onFailure(SdkError sdkError) {
                    Log.e(TAG, "MapUiApi: LocServices: onFailure: " + sdkError);
                    // Handle location services failure...
                }
            }
    );
}
    private void setupMapstedSdk() {

        tStartInitMapsted = System.currentTimeMillis();

        CoreParams.Builder<? extends CoreParams, ? extends CoreParams.Builder> builder =
                CoreParams.newBuilder();

        CoreParams params = builder
            // Add additional custom content here
            .build();

        coreApi.setup().initialize(
            params,
            new CoreApi.CoreInitCallback() {
                @Override
                public void onSuccess() {

                    tInitMapstedFinished = System.currentTimeMillis();
                    double dtInitSec = (tInitMapstedFinished - tStartInitMapsted) / 1000.0;

                    String msg = String.format(Locale.CANADA, "coreApi: onSuccess. dt: %.1f s", dtInitSec);

                    Log.d(TAG, msg);

                    coreApi.setup().startLocationServices(MainActivity.this,
                        new LocationServicesCallback() {
                            @Override
                            public void onSuccess() {
                                Log.d(TAG, "coreApi: LocServices: onSuccess");
                            }

                            @Override
                            public void onFailure(SdkError sdkError) {
                                Log.d(TAG, "coreApi: LocServices: onFailure " + sdkError.toString());
                            }
                        });
                }

                @Override
                public void onFailure(SdkError sdkError) {
                    Log.d(TAG, "coreApi: onFailure: " + sdkError);
                }

                @Override
                public void onStatusUpdate(SdkStatusUpdate sdkUpdate) {
                    Log.d(TAG, "coreApi: onStatusUpdate: " + sdkUpdate);
                }
            }
        );
    }

    private void startPropertyDownload(int propertyId) {
        Log.d(TAG, "startPropertyDownload: pId: " + propertyId);

        tStartDownload = System.currentTimeMillis();

        coreApi.properties().startDownload(
            propertyId,
            new PropertyDownloadManager.Listener() {
                @Override
                public void onComplete(int propertyId) {

                    tDownloadFinished = System.currentTimeMillis();

                    double dtDownloadSec = (tStartDownload - tDownloadFinished) / 1000.0;

                    String msg = String.format(Locale.CANADA,
                        "startPropertyDownload: onComplete: pId: %d dt: %.1f s",
                        propertyId, dtDownloadSec);

                    Log.d(TAG, msg);
                }

                @Override
                public void onFail(int propertyId, Exception exception) {

                    String msg = "startPropertyDownload: onFail: pId: " + propertyId + " -> " + exception.getMessage();

                    Log.d(TAG, msg);
                }

                @Override
                public void onProgress(int propertyId, int current, int total) {
                    Log.d(TAG, "startPropertyDownload: onProgress: pId: " + propertyId + " -> (" + current + " / " +           total + ")");
                }
            }
        );
    }

    @Override
    public CoreApi provideMapstedCoreApi() {
        return coreApi;
    }
}
