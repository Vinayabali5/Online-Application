/**
 * This is the definition of the Online Applications main site features.
 */
(function() {

    angular
        .module('oas.application-submission')
        .controller('ApplicationSubmissionController', ApplicationSubmissionController);

    ApplicationSubmissionController.$inject = ['$scope', 'Logger', 'CONFIG', 'institutions'];

    function ApplicationSubmissionController($scope, Logger, CONFIG, institutions) {
        var vm = this;

        // Public Interface
        $scope.debug = CONFIG.debug;
        $scope.fullDebug = false;

        $scope.institutions = institutions.data;

        // $scope.submitApplication = submitApplication;
        $scope.createSelectedCourseArray = createSelectedCourseArray;

        $scope.submit = submitApplication;

        $scope.submissions = [];

        init();

        // Private Interface

        function init() {
            createSubmissionData();
        }

        function createSubmissionData() {
            $scope.institutions.forEach(function(element) {
                var submission = {
                    institution: element,
                    selectedCourses: createSelectedCourseArray(element.maxCourses)
                };
                $scope.submissions.push(submission);
            });
        }

        function createSelectedCourseArray(size) {
            var output = [];
            for (var i = 0; i < size; i++) {
                output.push({});
            }
            return output;
        }

        function submitApplication() {
            // TODO: Create the submission routine

            // Step 1: create submission for each selected institution (institution, selected courses)
            $scope.submissions.forEach(function(submission) {
                Logger.debug(submission);
                if (submission.institution.selected === true) {
                    Logger.debug('Selected: ' + submission.institution.name);
                }
            });


            // Step 2: submit to API

        }

    }

})();
