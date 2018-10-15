/**
 * This is the definition of the application's configuraiton and initial launch.
 */
(function() {

    initialiseApplication.$inject = ['$log', '$rootScope', '$location', '$state', '$stateParams', 'GLOBAL'];
    initialiseAuthentication.$inject = ['$log', '$rootScope', '$state', 'GLOBAL'];

    function initialiseApplication($log, $rootScope, $location, $state, $stateParams, GLOBAL) {

        var DEBUG = GLOBAL.DEBUG;

        $log.info('II TemplateApplication - run');
        $rootScope.GLOBAL = GLOBAL;

        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;

        $rootScope.$on('$stateChangeStart', function(event, toState, toStateParams) {
            $rootScope.toState = toState;
            $rootScope.toStateParams = toStateParams;
        });

        $rootScope.back = function() {
            // If previous state is 'activate' or do not exist go to 'home'
            if ($rootScope.previousStateName === 'activate' || $state.get($rootScope.previousStateName) === null) {
                $state.go('site.home');
            } else {
                $state.go($rootScope.previousStateName, $rootScope.previousStateParams);
            }
        };
    }

    // Set up Authentication and Authorization
    function initialiseAuthentication($log, $rootScope, $state, GLOBAL) { // Authentication handler
        $rootScope.$on('$locationChangeStart', function(event, next, current) {
            var DEBUG = GLOBAL.DEBUG;

            if (DEBUG) $log.log('II Login Check');

            var isStateLogin = $state.is('login');

        });
    }

    angular
        .module('oas')
        .run(initialiseApplication)
        .run(initialiseAuthentication);

})();
