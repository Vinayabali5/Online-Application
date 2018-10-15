/**
 * This is the definition of the application's configuraiton and initial launch.
 */
(function() {

    angular
        .module('oas', [
            'oas.interceptor.auth',

            'oas.site',
        ]);

})();
