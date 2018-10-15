(function() {
    angular
        .module('oas.directive.predicted-grades-editor')
        .controller('PredictedGradesEditorController', PredictedGradesEditorController);

    PredictedGradesEditorController.$inject = ['$scope', '$uibModal', 'Logger', 'CONFIG'];

    function PredictedGradesEditorController($scope, $uibModal, Logger, CONFIG) {
        var vm = this;

        // Public Interface

        $scope.add = addPredictedGrade;
        $scope.edit = editPredictedGrade;
        $scope.remove = removePredictedGrade;

        // Private Interface

        function openDialog(predictedGrade, title) {
            var defaultTitle = "Create or edit a Entry Qualification";

            var modalOptions = {
                templateUrl: 'js/components/directives/predicted-grades-editor/views/dialog.html',
                controller: 'PredictedGradesEditorAddDialogController',
                controllerAs: 'ctrl',
                size: 'lg',
                resolve: {
                    predictedGrade: function() {
                        return predictedGrade;
                    }
                }
            };
            return $uibModal.open(modalOptions);
        }

        function addPredictedGrade() {
            Logger.log('Open Add Predicted Grade Dialog');
            var newPredictedGrade = Object.assign({}, CONFIG.defaults.predictedGrade);
            openDialog(newPredictedGrade).result.then(function(response) {
                Logger.debug(response);
                if (response !== null && response !== undefined) {
                    var exists = $scope.predictedGrades.find(function(it) {
                        return it.qualification.id === response.qualification.id && it.yearOfExamination === response.yearOfExamination;
                    });
                    if (exists === undefined) {
                        Logger.log("Predicted Grade Added", true);
                        $scope.predictedGrades.push(response);
                    } else {
                        Logger.warn("Predicted Grade already exists for this qualification in this year. Please edit the existing item in the list if you want to make a change.", true);
                    }
                }
            }, function() {
                Logger.debug("Dialog Dismissed");
            });
        }

        function editPredictedGrade(predictedGrade) {
            openDialog(predictedGrade);
        }

        function removePredictedGrade(predictedGrade) {
            bootbox.confirm({
                message: "You are about to remove a predicted grade from the list. Are you sure?",
                buttons: {
                    confirm: {
                        label: 'Yes',
                        className: 'btn-primary'
                    },
                    cancel: {
                        label: 'No',
                        className: 'btn-danger'
                    }
                },
                callback: function(result) {
                    if (result === true) {
                        $scope.predictedGrades.pop(predictedGrade);
                        $scope.$apply();
                    }
                }
            });
        }
    }
})();
