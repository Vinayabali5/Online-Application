(function() {
    angular
        .module('oas.selection.school', [
            'oas.service.logger',
            'oas.service.school',
        ])
        .directive('schoolSelection', SchoolSelectionDirective);

    SchoolSelectionDirective.$inject = ['Logger', 'School'];

    function SchoolSelectionDirective(Logger, School) {
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
            controller: function(School) {
                var vm = this;
                vm.schools = [];

                School.query().then(function(response) {
                    vm.schools = response.data;
                }, function(response) {
                    Logger.error("Error Retrieving Schools");
                });
            },
            controllerAs: 'ctrl',
            templateUrl: 'js/components/selection/school/school.selection.html',

        };
    }
})();
