/**
 * This is the factory definition for the Institution Data Service. This defines how to handle data about Institution objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.institution', ['oas.config'])
        .factory('Institution', institutionFactory);

    institutionFactory.$inject = ['$http', 'CONFIG'];

    function institutionFactory($http, CONFIG) {
        var url = CONFIG.api + '/api/institutions';
        var service = {};

        // Public Interface

        service.query = getAll;

        return service;

        // Private Interface

        /**
         * This method is used to retrieve all the Institution from the API collection.
         *
         * @return {Array} An array of Institution objects.
         */
        function getAll() {
            return $http.get(url);
        }

    }

})();
