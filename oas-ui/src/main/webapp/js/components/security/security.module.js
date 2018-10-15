/**
 * This is the definition of the security module. Has various components to deal with user authentication and authorisation.
 */
(function() {

    angular.module('oas.security', [
        'ngCookies',
        'oas.config',
        'oas.util.base64',
    ]);

})();
