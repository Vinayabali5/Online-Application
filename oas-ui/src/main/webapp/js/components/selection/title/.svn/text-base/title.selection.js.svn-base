(function() {
    angular
        .module('oas.selection.title', [
            'oas.service.logger',
            'oas.service.title',
        ])
        .directive('titleSelection', TitleSelectionDirective);

    TitleSelectionDirective.$inject = ['Logger', 'Title'];

    function TitleSelectionDirective(Logger, Title) {
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
            controller: function(Title) {
                var vm = this;
                vm.titles = [];

                Title.query().then(function(response) {
                    vm.titles = response.data;
                }, function(response) {
                    Logger.error("Error Retrieving Titles");
                });
            },
            controllerAs: 'ctrl',
            templateUrl: 'js/components/selection/title/title.selection.html',

        };
    }
})();
