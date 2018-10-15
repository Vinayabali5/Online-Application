/**
 * This is the factory definition for the School Data Service. This defines how to handle data about School objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.school', ['oas.config'])
        .factory('School', schoolFactory);

    schoolFactory.$inject = ['$http', 'CONFIG'];

    function schoolFactory($http, CONFIG) {
        var url = CONFIG.api + '/api/lookup/schools';
        var service = {};

        //Public Interface

        service.query = getAll;

        return service;

        // Private Interface

        /**
         * This method is used to retrieve all the School from the API collection.
         *
         * @return {Array} An array of School objects.
         */
        function getAll() {
            return $http.get(url);
        }

    }

})();
