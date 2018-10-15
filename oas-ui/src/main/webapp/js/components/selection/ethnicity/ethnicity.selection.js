(function() {
    angular
        .module('oas.selection.ethnicity', [
            'oas.service.logger',
            'oas.service.ethnicity',
        ])
        .directive('ethnicitySelection', EthnicitySelectionDirective);

    EthnicitySelectionDirective.$inject = ['Logger', 'Ethnicity'];

    function EthnicitySelectionDirective(Logger, Ethnicity) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                readonly: '=?',
                ngModel: '='
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: function(Ethnicity) {
                var vm = this;
                vm.ethnicities = [];

                Ethnicity.query().then(function(response) {
                    vm.ethnicities = response.data;
                }, function(response) {
                    Logger.error("Error Retrieving Ethnicities");
                });
            },
            controllerAs: 'ctrl',
            templateUrl: 'js/components/selection/ethnicity/ethnicity.selection.html',

        };
    }
})();
