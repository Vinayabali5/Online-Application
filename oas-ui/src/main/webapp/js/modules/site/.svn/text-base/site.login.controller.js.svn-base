/**
 * This is the definition of the Online Applications main site features.
 */
(function() {

    angular.module('oas.site').controller('OASSiteLoginController', OASSiteLoginController);

    OASSiteLoginController.$inject = ['$state', 'Logger', 'AuthenticationService'];

    function OASSiteLoginController($state, Logger, AuthenticationService) {
        var vm = this;

        vm.login = login;

        (function initController() {
            // reset login status
            AuthenticationService.clearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.login(vm.username, vm.password, function(response) {
                if (response.success) {
                    Logger.log('Login Successful');
                    AuthenticationService.setCredentials(vm.username, vm.password);
                    vm.dataLoading = false;
                    $state.go('home');
                } else {
                    Logger.error('Login Failed: ' + response.message, true);
                    vm.dataLoading = false;
                }
            });
        }

    }

})();
