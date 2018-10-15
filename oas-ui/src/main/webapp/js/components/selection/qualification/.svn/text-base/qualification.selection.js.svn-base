(function() {
    angular
        .module('oas.selection.qualification', [
            'oas.service.logger',
            'oas.service.qualification',
        ])
        .directive('qualificationSelection', QualificationSelectionDirective);

    QualificationSelectionDirective.$inject = ['Logger', 'Qualification'];

    function QualificationSelectionDirective(Logger, Qualification) {
        return {
            restrict: 'E',
            scope: {
                class: '@',
                readonly: '=?',
                ngModel: '='
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: function(Qualification) {
                var vm = this;
                vm.qualifications = [];

                Qualification.query().then(function(response) {
                    vm.qualifications = response.data;
                }, function(response) {
                    Logger.error("Error Retrieving Qualifications");
                });
            },
            controllerAs: 'ctrl',
            templateUrl: 'js/components/selection/qualification/qualification.selection.html',
        };
    }
})();
