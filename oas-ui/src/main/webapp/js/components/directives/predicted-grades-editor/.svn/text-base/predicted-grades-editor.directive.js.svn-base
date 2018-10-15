(function() {
    angular
        .module('oas.directive.predicted-grades-editor', [
            'ui.bootstrap.modal',
            'oas.config',
            'oas.service.logger',
            'oas.service.qualification',
            'oas.selection.qualification',
        ])
        .directive('predictedGradesEditor', PredictedGradesEditorDirective);

    PredictedGradesEditorDirective.$inject = ['Logger'];

    function PredictedGradesEditorDirective(Logger) {
        return {
            restrict: 'E',
            scope: {
                predictedGrades: '=',
            },
            templateUrl: 'js/components/directives/predicted-grades-editor/predicted-grades-editor.html',
            controller: 'PredictedGradesEditorController',
            controlerAs: 'ctrl',
        };
    }
})();
