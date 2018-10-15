(function() {
    angular
        .module('oas.directive.contact-details', [
            'oas.service.logger',
            'oas.selection.contact-type',
            'oas.selection.title',
            'oas.directive.address-details',
        ])
        .directive('contactDetails', ContactDetailsDirective);

    ContactDetailsDirective.$inject = ['Logger'];

    function ContactDetailsDirective(Logger) {
        return {
            restrict: 'E',
            scope: {
                label: '@',
                contact: '=',
            },
            //controller: ,
            //controllerAs: 'ctrl',
            templateUrl: 'js/components/directives/contact-details/contact-details.html',

        };
    }
})();
