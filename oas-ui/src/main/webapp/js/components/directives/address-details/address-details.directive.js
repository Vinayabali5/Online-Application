(function() {
    angular
        .module('oas.directive.address-details', [
            'ui.bootstrap.modal',
            'oas.config',

            'oas.directive.uppercase',

            'oas.service.logger',
            'oas.service.postcode-lookup',
        ])
        .directive('addressDetails', AddressDetailsDirective);

    AddressDetailsDirective.$inject = ['Logger'];

    function AddressDetailsDirective(Logger) {
        return {
            restrict: 'E',
            scope: {
                label: '@',
                isRequired: '@',
                address: '=',
            },
            templateUrl: 'js/components/directives/address-details/address-details.html',
            controller: 'AddressDetailsController',
            controlerAs: 'ctrl',
        };
    }
})();
