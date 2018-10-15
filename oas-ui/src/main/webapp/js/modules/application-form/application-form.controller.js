/**
 * This is the definition of the Online Applications main site features.
 */
(function() {

    angular
        .module('oas.application-form')
        .controller('ApplicationFormController', ApplicationFormController);

    ApplicationFormController.$inject = ['$rootScope', '$scope', '$state', 'Logger', 'ApplicationForm', 'CONFIG', 'UIData'];

    function ApplicationFormController($rootScope, $scope, $state, Logger, ApplicationForm, CONFIG, UIData) {
        var vm = this;

        // Public Interface
        Logger.debug('Loading: ' + $state.current.name);

        // if (UIData.status == undefined) {
        //     Logger.debug('Setting UIData Status');
        //     UIData.status = applicationFormStatus.data;
        // }
        // if (UIData.application == undefined) {
        //     Logger.debug('Setting UIData Application');
        //     UIData.application = applicationForm.data;
        // }

        $scope.debug = CONFIG.debug;
        $scope.datePickerOptions = CONFIG.options.datepicker;
        $scope.monthPickerOptions = CONFIG.options.monthpicker;

        $scope.status = UIData.status;
        $scope.application = UIData.application;

        $scope.save = save;
        $scope.saveAndNext = saveAndNext;
        $scope.cancel = cancel;

        $scope.saveAndNextEnabled = hasNextState();

        $scope.test = reloadApplication;

        // Private Interface

        $rootScope.$on('application-saved', function() {
            Logger.log('Application Saved Event caught.');
            refreshStatus();
        });


        function save(callback) {
            ApplicationForm.saveApplication($scope.application).then(function(response) {
                Logger.log("Application Form saved", true);
                UIData.application = response.data;
                refreshStatus();
                if (callback !== undefined && typeof callback == "function") {
                    callback();
                }
            }, function(response) {
                Logger.error("There was a problem saving your application: " + response.data.message, true);
            });
        }

        function saveAndNext() {
            save(function() {
                if ($state.current.data.nextState !== undefined) {
                    $state.go($state.current.data.nextState);
                }
            });
        }

        function cancel() {
            bootbox.confirm({
                message: "You are about to cancel. This will revert all changes you have currently made without saving. Are you sure?",
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
                    Logger.debug('Cancel confirmation: ' + result);
                    if (result === true) {
                        reloadApplication();
                    }
                }
            });
        }

        function hasNextState() {
            Logger.debug($state);
            Logger.debug($state.current);
            var currentState = $state.current;
            var dataDefined = $state.current.data !== undefined;
            var nextStateDefined = false;
            if (dataDefined) {
                nextStateDefined = $state.current.data.nextState !== undefined;
            }
            return nextStateDefined;
        }

        function refreshStatus() {
            Logger.debug('Refreshing application status');
            ApplicationForm.status().then(function(response) {
                UIData.status = response.data;
            });
        }

        function reloadApplication() {
            ApplicationForm.loadApplication().then(function(response) {
                Logger.log('Application form loaded', true);
                UIData.application = response.data;
            });
        }

    }

})();
