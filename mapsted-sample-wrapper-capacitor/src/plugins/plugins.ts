import { registerPlugin } from '@capacitor/core';

export interface MapstedIonicPluginI {
    echo(options: { value: string }): Promise<{ value: string }>;
    getBuildingInfo(options: { buildingId: number }): Promise<{ BuildingInfo: any }>;
    launchMapActivity(): Promise<void>; // Add this method for launching MapstedMapActivity
    getSearchCoreSdkCallback(): Promise<any>;
    getSearchFeedCallback(): Promise<any>;
    getSearchAlertCallback(): Promise<any>;
    initializeMapApis(): Promise<any>;

}

const MapstedIonicPlugin = registerPlugin<MapstedIonicPluginI>('MapstedIonicPlugin');

export {
    MapstedIonicPlugin
};