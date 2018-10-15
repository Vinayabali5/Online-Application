(function() {
    angular
        .module('oas.directive.sibling-details', [
            'oas.service.logger',
        ])
        .directive('siblingDetails', SiblingDetailsDirective);

    SiblingDetailsDirective.$inject = ['Logger'];

    function SiblingDetailsDirective(Logger) {
        return {
            restrict: 'E',
            scope: {
                label: '@',
                application: '=',
            },
            templateUrl: 'js/components/directives/sibling-details/sibling-details.html',
        };
    }
})();
