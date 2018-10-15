/**
 * This is the factory definition for the ApplicationForm Data Service. This defines how to handle data about ApplicationForm objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.application-form', ['oas.config'])
        .factory('ApplicationForm', applicationFormFactory);

    applicationFormFactory.$inject = ['$q', '$http', '$rootScope', 'CONFIG'];

    function applicationFormFactory($q, $http, $rootScope, CONFIG) {
        var url = CONFIG.api + '/api/application';
        var service = {};

        //Public Interface

        service.status = status;
        service.loadApplication = loadApplication;
        service.saveApplication = saveApplication;

        return service;

        // Private Interface

        /**
         * This method is used to retrieve all the ApplicationForm from the API collection.
         *
         * @return {Promise} A promise from the API with the ApplicationForm object in the response.data.
         */
        function loadApplication() {
            return $http.get(url);
        }

        /**
         * This method is used to retrieve the current application status from the API.
         *
         * @return {Promise} Returns a promise of the data from the API
         */
        function status() {
            return $http.get(url + '/status');
        }

        /**
         * This method is used to save the supplied application form to the API.
         *
         * @param  {Object} application an application object to be sent to the API for saving
         * @return {Promise}
         */
        function saveApplication(application) {
            var deferred = $q.defer();
            $http.put(url, application).then(function(response) {
                deferred.resolve(response);
                $rootScope.$emit('application-saved', response.data);
            }, function(response) {
                deferred.reject(response);
            });
            return deferred.promise;
        }

    }

})();
