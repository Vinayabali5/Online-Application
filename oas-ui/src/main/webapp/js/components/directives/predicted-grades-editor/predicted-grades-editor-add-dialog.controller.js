(function() {
    angular
        .module('oas.directive.predicted-grades-editor')
        .controller('PredictedGradesEditorAddDialogController', PredictedGradesEditorAddDialogController);

    PredictedGradesEditorAddDialogController.$inject = ['$scope', '$uibModalInstance', 'Logger', 'predictedGrade'];

    function PredictedGradesEditorAddDialogController($scope, $uibModalInstance, Logger, predictedGrade) {
        var vm = this;

        // Public Interface

        $scope.predictedGrade = predictedGrade;

        $scope.save = save;
        $scope.cancel = cancel;

        // Private Interface

        var onSaveFinished = function(result) {
            $scope.$emit('predicted-grade-added', result);
            $uibModalInstance.close(result);
        };

        function save() {
            Logger.debug("Save Clicked");
            $uibModalInstance.close($scope.predictedGrade);
        }

        function cancel() {
            Logger.debug("Cancel Clicked");
            $uibModalInstance.dismiss('cancel');
        }


    }
})();
