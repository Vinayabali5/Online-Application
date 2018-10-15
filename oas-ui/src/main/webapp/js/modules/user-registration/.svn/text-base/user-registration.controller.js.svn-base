/**
 * This is the definition of the Online Applications main site features.
 */
(function() {

    angular
        .module('oas.user-registration')
        .controller('UserRegistrationController', UserRegistrationController);

    UserRegistrationController.$inject = ['$state', 'Logger', 'UserRegistrationService'];

    function UserRegistrationController($state, Logger, UserRegistrationService) {
        var vm = this;

        vm.submitted = false;

        vm.user = {
            email: 'test@test.com',
            legalFirstName: 'Test',
            legalSurname: 'Smith',
            dob: new Date(Date.parse('01/01/2000')),
            school: 1
        };

        vm.register = register;

        function register() {
            vm.submitted = true;
            UserRegistrationService.create(vm.user).then(function(response) {
                if (response.success) {
                    Logger.log('Registration Submitted', true);
                    $state.go('registration.confirmemail');
                } else {
                    Logger.error('Registration Failed', true);
                    vm.submitted = false;
                }
            }, function(response) {
                Logger.error('Registration Failed: ' + response.message, true);
                vm.submitted = false;
            });
        }

    }

})();
