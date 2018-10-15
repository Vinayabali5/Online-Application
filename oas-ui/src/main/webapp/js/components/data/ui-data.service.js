/**
 * This is the factory definition for the UI Data Service. This is a shared repository of data used for storing data used in the UI.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.ui-data', [
            'oas.service.logger',
            'oas.service.application-form',
        ])
        .factory('UIData', UIDataFactory);

    UIDataFactory.$inject = ['$q', 'Logger', 'ApplicationForm'];

    function UIDataFactory($q, Logger, ApplicationForm) {
        var service = {};

        //Public Interface

        service.promise = promiseChain();
        service.application = {};
        service.status = {};

        //initialise();
        return service;

        // Private Interface

        function initialise() {
            Logger.debug('Initialising UI Data');
            ApplicationForm.status().then(function(response) {
                service.status = response.data;
            });
            ApplicationForm.loadApplication().then(function(response) {
                service.application = response.data;
            });
        }

        function promiseChain() {
            var deferred = $q.defer();
            var allPromises = $q.all([
                ApplicationForm.status().then(function(response) {
                    Logger.debug('Initialising UI Data - Status');
                    service.status = response.data;
                }),
                ApplicationForm.loadApplication().then(function(response) {
                    Logger.debug('Initialising UI Data - Application');
                    service.application = response.data;
                })
            ]).then(function() {
                deferred.resolve();
            }, function() {
                var message = 'An error occurred retrieving the application data.';
                Logger.error(message, true);
                deferred.reject(message);
            });
            return deferred.promise;
        }

    }

})();
