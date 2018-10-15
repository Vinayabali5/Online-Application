(function() {
    angular
        .module('oas.selection.gender', [
            'oas.service.logger',
            'oas.service.gender',
        ])
        .directive('genderSelection', GenderSelectionDirective);

    GenderSelectionDirective.$inject = ['Logger', 'Gender'];

    function GenderSelectionDirective(Logger, Gender) {
        return {
            restrict: 'E',
            scope: {
                id: '@',
                class: '@',
                required: '@',
                readonly: '=?',
                ngModel: '='
            },
            link: function(scope, element, attrs) {
                element[0].removeAttribute('id');
                element[0].removeAttribute('class');
                element[0].removeAttribute('readonly');
                element[0].disable = scope.readonly;
            },
            controller: function(Gender) {
                var vm = this;
                vm.genders = [];

                Gender.query().then(function(response) {
                    vm.genders = response.data;
                }, function(response) {
                    Logger.error("Error Retrieving Genders");
                });
            },
            controllerAs: 'ctrl',
            templateUrl: 'js/components/selection/gender/gender.selection.html',

        };
    }
})();
