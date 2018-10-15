(function() {
    angular
        .module('oas.directive.course-selector', [
            'ngSanitize',
            'ui.bootstrap.typeahead',

            'oas.filter.none',
        ])
        .directive('courseSelector', CourseSelectorDirective);

    CourseSelectorDirective.$inject = ['Logger'];

    function CourseSelectorDirective(Logger) {
        return {
            restrict: 'E',
            scope: {
                name: '@',
                isRequired: '@',
                courses: '=',
                ngModel: '='
            },
            link: function(scope, element, attrs) {
                var input = element.find('input')[0];
                input.name = scope.name;
                if (scope.isRequired == true) {
                    input.required = true;
                } else {
                    input.removeAttribute('required');
                }
            },
            templateUrl: 'js/components/directives/course-selector/course-selector.html',
            // controlerAs: 'ctrl',
            // controller: 'CourseSelectorController',
        };
    }
})();
