/**
 * This is the definition of the User Registration module.
 */
(function() {

    angular
        .module('oas.user-registration', [
            'ui.router',
            'ui.bootstrap',
            'ui-notification',

            'oas.service.logger',

            'oas.security',
            'oas.service.user-registration',
            'oas.service.school',

            'oas.selection.school',
        ]);

})();
