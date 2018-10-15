(function() {

    angular
        .module('oas.site')
        .run(initialiseSite)
        .run(initialiseUser);

    //.run(initialiseSiteAuthentication)

    initialiseSite.$inject = ['$rootScope', '$cookies', '$transitions', 'Logger', 'CONFIG'];
    initialiseUser.$inject = ['$rootScope', '$http', 'Logger'];

    function initialiseSite($rootScope, $cookies, $transitions, Logger, CONFIG) {
        Logger.log('Initialising Site');
        $rootScope.globals = $cookies.getObject('globals') || {};
        $transitions.onStart({}, function(trans) {
            var targetState = trans.$to();
            Logger.log(targetState);
        });

        $transitions.onError({}, function($transitions$) {
            if (CONFIG.debug == true) {
                Logger.debug($transitions$._error);
            }
            if ($transitions$._error.type == 6) {
                Logger.error("Failed to load page.", true);
            }
        });

    }

    function initialiseUser($rootScope, $http, Logger) {
        Logger.log('Initialising User');
        if ($rootScope.globals !== undefined && $rootScope.globals.currentUser !== undefined && $rootScope.globals.currentUser.authdata !== undefined) {
            $http.defaults.headers.common.Authorization = 'Basic ' + $rootScope.globals.currentUser.authdata;
        }
    }


})();
