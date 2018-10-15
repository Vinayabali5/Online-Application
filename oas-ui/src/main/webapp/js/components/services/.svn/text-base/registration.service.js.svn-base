(function() {
    'use strict';

    angular
        .module('oas.service.user-registration', [])
        .factory('UserRegistrationService', UserRegistrationService);

    UserRegistrationService.$inject = ['$q', '$http', 'CONFIG'];

    function UserRegistrationService($q, $http, CONFIG) {
        var baseUrl = CONFIG.api + '/api/register';
        var deferred;
        var service = {};

        // Public Interface

        service.create = create;
        service.loadConfirmation = loadConfirmation;
        service.setPassword = setPassword;
        return service;

        // Private Interface

        function create(user) {
            deferred = $q.defer();
            $http.post(baseUrl, user).then(handleSuccess, handleError);
            return deferred.promise;
        }

        function loadConfirmation(confirmationCode) {
            deferred = $q.defer();
            $http.get(baseUrl + '/confirm/' + confirmationCode).then(handleSuccess, handleError);
            return deferred.promise;
        }

        function setPassword(confirmationCode, passwordInfo) {
            deferred = $q.defer();
            $http.post(baseUrl + '/confirm/' + confirmationCode, passwordInfo).then(handleSuccess, handleError);
            return deferred.promise;
        }

        // Private Functions

        function handleSuccess(res) {
            return deferred.resolve(res.data);
        }

        function handleError(error) {
            return deferred.reject({
                success: false,
                message: error.data.message
            });
        }
    }
})();
