var exec = require("cordova/exec");

var PLUGIN_NAME = "CordovaPluginMapsted";

exports.coolMethod = function (arg0, success, error) {
  exec(success, error, PLUGIN_NAME, "coolMethod", [arg0]);
};

module.exports.echo = function (arg0, success, error) {
  exec(success, error, PLUGIN_NAME, "echo", [arg0]);
};

module.exports.launchMapActivity = function (success, error) {
  exec(success, error, PLUGIN_NAME, "launchMapActivity", []);
};

module.exports.getSearchCoreSdkCallback = function (success, error) {
  exec(success, error, PLUGIN_NAME, "getSearchCoreSdkCallback", []);
};

module.exports.getSearchFeedCallback = function (success, error) {
  exec(success, error, PLUGIN_NAME, "getSearchFeedCallback", []);
};

module.exports.getSearchAlertCallback = function (success, error) {
  exec(success, error, PLUGIN_NAME, "getSearchAlertCallback", []);
};