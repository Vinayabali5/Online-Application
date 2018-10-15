/**
 * This defines the AuthenticationService which is used to authenticate the user against the API. This service handles
 * login attempts and the setting of user credentials.
 */
(function() {

    angular
        .module('oas.security')
        .factory('AuthenticationService', AuthenticationService);

    AuthenticationService.$inject = ['$http', '$rootScope', '$cookies', 'Base64', 'CONFIG'];

    function AuthenticationService($http, $rootScope, $cookies, Base64, CONFIG) {
        var service = {};

        service.login = login;
        service.setCredentials = setCredentials;
        service.clearCredentials = clearCredentials;

        return service;

        /**
         * This method is used to login into the API using ausername and password.
         *
         * @param {String}   username The username to use to authenticate.
         * @param {String}   password The password to use to authenticate.
         * @param {Function} callback A callback function that is called when the authentication attempt is complete.
         */
        function login(username, password, callback) {
            var output = {
                success: false,
                user: null
            };
            setCredentials(username, password);
            $http.get(CONFIG.api + '/api/auth').then(
                function(response) {
                    // Successful Authentication
                    callback(handleSuccess(response));
                },
                function(response) {
                    // Failed Authentication
                    clearCredentials();
                    callback(handleFailure(response));
                }
            );
        }

        /**
         * This method is used to set the user credentials for API requests.
         *
         * @param {String} username The username to use for a users credentials.
         * @param {String} password The password to use for a users credentials.
         */
        function setCredentials(username, password) {
            var authdata = Base64.encode(username + ':' + password);

            $rootScope.globals = {
                currentUser: {
                    username: username,
                    authdata: authdata
                }
            };

            // set default auth header for http requests
            $http.defaults.headers.common.Authorization = 'Basic ' + authdata;

            // store user details in globals cookie that keeps user logged in for 1 week (or until they logout)
            var cookieExp = new Date();
            cookieExp.setDate(cookieExp.getDate() + 7);
            $cookies.putObject('globals', $rootScope.globals, {
                expires: cookieExp
            });
        }

        /**
         * This method is used to clear any stored user credentials from the application.
         *
         */
        function clearCredentials() {
            $rootScope.globals = {};
            $cookies.remove('globals');
            $http.defaults.headers.common.Authorization = 'Basic';
        }

        /**
         * This function is used to handle a successful login attempt.
         *
         * @param {response} response The response entity from the API.
         * @return {object}           An object with a success flag and an embedded user object.
         */
        function handleSuccess(response) {
            var output = {
                success: false
            };
            if (response.status == 200) {
                output.success = true;
                output.user = response.data;
            }
            return output;
        }

        /**
         * This function i sused to handle a failed login attempt.
         *
         * @param {response} response The response entity from the API.
         * @return {object}           An object with success flag and the error message from the API.
         */
        function handleFailure(response) {
            var output = {
                success: false,
                message: response.data.message
            };
            return output;
        }
    }

})();
