/**
 * This is the definition of the Online Applications main site features.
 */
(function() {

    angular
        .module('oas.site', [
            'ngCookies',
            'ui.router',
            'ui-notification',

            'oas.service.logger',
            'oas.security',

            'oas.user-registration',
            'oas.application-form',
            'oas.application-submission',
        ]);

})();
