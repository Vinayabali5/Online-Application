/**
 * This is the definition of the Online Applications main site features.
 */
(function() {
    angular
        .module('oas.interceptor.auth', [])
        .factory('authInterceptor', authInterceptor);

    authInterceptor.$inject = ['$q', '$state'];

    /**
     * This interceptor service is designed to redirect the user to the login screen if a 401 error is encountered.
     *
     * @param  {Provider} $q     The promise provider
     * @param  {Provider} $state The state provider
     * @return {Promise}         The promise chain
     */
    function authInterceptor($q, $state) {
        var service = {};
        service.responseError = responseError;
        return service;

        function responseError(response) {
            if (response.status === 401) {
                $state.go('login');
            }
            return $q.reject(response);
        }

    }
})();
