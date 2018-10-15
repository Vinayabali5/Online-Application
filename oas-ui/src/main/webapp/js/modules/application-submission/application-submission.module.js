/**
 * This is the definition of the Online Applications main site features.
 */
(function() {

    angular
        .module('oas.application-submission', [
            'ui.router',
            'ui-notification',

            'oas.filter.yes-no',

            'oas.service.logger',
            'oas.service.institution',

            'oas.directive.course-selector',

        ]);

})();
