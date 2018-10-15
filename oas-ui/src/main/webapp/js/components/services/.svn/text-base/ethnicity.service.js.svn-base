/**
 * This is the factory definition for the Ethnicity Data Service. This defines how to handle data about Ethnicity objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.ethnicity', ['oas.config'])
        .factory('Ethnicity', ethnicityFactory);

    ethnicityFactory.$inject = ['$http', 'CONFIG'];

    function ethnicityFactory($http, CONFIG) {
        var url = CONFIG.api + '/api/lookup/ethnicities';
        var service = {};

        // Public Interface

        service.query = getAll;

        return service;

        // Private Interface

        /**
         * This method is used to retrieve all the Ethnicity from the API collection.
         *
         * @return {Array} An array of Ethnicity objects.
         */
        function getAll() {
            return $http.get(url);
        }

    }

})();
