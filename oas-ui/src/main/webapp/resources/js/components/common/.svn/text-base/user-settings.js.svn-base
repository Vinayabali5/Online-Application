angular.module('cid.user-settings', ['ngCookies'])
    .factory('USER', function($log, $cookies, GLOBAL) {
        var DEBUG = GLOBAL.DEBUG;
        var COOKIE_NAME = 'cid.user-settings';
        var settings = {};

        return {
            load: load,
            save: save,
            clear: clear,
            setSetting: setSetting,
            getSetting: getSetting,
        };

        function load() {
            if (DEBUG) $log.info('II Loading User Settings');
            var loadedSettings = $cookies.getObject(COOKIE_NAME);
            if (loadedSettings !== undefined) {
                settings = $cookies.getObject(COOKIE_NAME);
            }
            return settings;
        }

        function save() {
            if (DEBUG) $log.info('II Saving User Settings');
            $cookies.putObject(COOKIE_NAME, settings);
        }

        function clear() {
            if (DEBUG) $log.info('II Clearing User Settings');
            settings = {};
            $cookies.remove(COOKIE_NAME);
        }

        function setSetting(key, value) {
            if (DEBUG) $log.info("II Setting '" + key + "' has being set to: " + value);
            if (!settings) settings = {};
            settings[key] = value;
            save();
        }

        function getSetting(key) {
            if (DEBUG) $log.info("II Setting '" + key + "' being retrieved");
            return settings[key];
        }

    });
