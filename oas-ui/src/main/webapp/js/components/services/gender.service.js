/**
 * This is the factory definition for the Gender Data Service. This defines how to handle data about Gender objects.
 *
 * Applied Styles: [Y001, Y002, Y010, Y021, Y022, Y023, Y024, Y050, Y051, Y052, Y053]
 *
 * @type Data Service
 */

(function() {

    angular
        .module('oas.service.gender', ['oas.config'])
        .factory('Gender', genderFactory);

    genderFactory.$inject = ['$http', 'CONFIG'];

    function genderFactory($http, CONFIG) {
        var url = CONFIG.api + '/api/lookup/genders';
        var service = {};

        // Public Interface

        service.query = getAll;

        return service;

        // Private Interface

        /**
         * This method is used to retrieve all the Gender from the API collection.
         *
         * @return {Array} An array of Gender objects.
         */
        function getAll() {
            return $http.get(url);
        }

    }

})();
