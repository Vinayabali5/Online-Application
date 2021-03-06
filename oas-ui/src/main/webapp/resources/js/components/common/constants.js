angular.module('cid.app.constants', ['cid.app.environment']).factory('GLOBAL', function($log, $http, EnvConfig) {
    return {
        DEBUG: (EnvConfig.debug === "true"),
        API: (EnvConfig.apiUrl !== undefined ? EnvConfig.apiUrl : '') + "/api",
        LOGIN: (EnvConfig.apiUrl !== undefined ? EnvConfig.apiUrl : '') + "/login",
        USER: (EnvConfig.apiUrl !== undefined ? EnvConfig.apiUrl : '') + "/user",
        REPORT_URL: EnvConfig.reportUrl,
        STUDENT_IMAGES_URL: EnvConfig.studentImagesUrl,
        PROFILE: EnvConfig.profile,
        DEFAULTS: {
            REPORT_FORMAT: 'PDF',
            REPORT_TOOLBAR: true
        },
    };
});
