/**
 * This is the factory definition for the Title Data Service. This defines how to handle data about Title objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.title', ['oas.config'])
        .factory('Title', titleFactory);

    titleFactory.$inject = ['$http', 'CONFIG'];

    function titleFactory($http, CONFIG) {
        var url = CONFIG.api + '/api/lookup/titles';
        var service = {};

        // Public Interface

        service.query = getAll;

        return service;

        // Private Interface

        /**
         * This method is used to retrieve all the Title from the API collection.
         *
         * @return {Array} An array of Title objects.
         */
        function getAll() {
            return $http.get(url);
        }

    }

})();
