/**
 * This is the factory definition for the Qualification Data Service. This defines how to handle data about Qualification objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.qualification', ['oas.config'])
        .factory('Qualification', qualificationFactory);

    qualificationFactory.$inject = ['$http', 'CONFIG'];

    function qualificationFactory($http, CONFIG) {
        var url = CONFIG.api + '/api/lookup/qualifications';
        var service = {};

        // Public Interface

        service.query = getAll;

        return service;

        // Private Interface

        /**
         * This method is used to retrieve all the Qualification from the API collection.
         *
         * @return {Array} An array of Qualification objects.
         */
        function getAll() {
            return $http.get(url);
        }

    }

})();
