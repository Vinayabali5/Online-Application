/**
 * This is the definition of the Online Applications main site features.
 */
(function() {

    angular
        .module('oas.user-registration')
        .controller('UserRegistrationConfirmationController', UserRegistrationConfirmationController);

    UserRegistrationConfirmationController.$inject = ['$state', '$stateParams', 'Logger', 'UserRegistrationService', 'confirmationInfo'];

    function UserRegistrationConfirmationController($state, $stateParams, Logger, UserRegistrationService, confirmationInfo) {
        var vm = this;

        vm.confirmation = {};
        vm.info = confirmationInfo;

        vm.completeRegistration = completeRegistration;

        function completeRegistration() {
            vm.submitted = true;
            UserRegistrationService.setPassword($stateParams.confirmationCode, vm.confirmation).then(function(response) {
                Logger.log('Password Successfully Set', true);
                $state.go('login');
            }, function(response) {
                Logger.error('Account Confirmation Failed: ' + response.message, true);
            });
        }
    }

})();
